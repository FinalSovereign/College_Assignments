/***************************************************************
 * Name:      wxEditorMain.cpp
 * Purpose:   Code for Application Frame
 * Author:     ()
 * Created:   2017-06-05
 * Copyright:  ()
 * License:
 **************************************************************/

#ifdef WX_PRECOMP
#include "wx_pch.h"
#endif

#ifdef __BORLANDC__
#pragma hdrstop
#endif //__BORLANDC__

#include "wxEditorMain.h"

//helper functions
enum wxbuildinfoformat {
    short_f, long_f };

wxString wxbuildinfo(wxbuildinfoformat format)
{
    wxString wxbuild(wxVERSION_STRING);

    if (format == long_f )
    {
#if defined(__WXMSW__)
        wxbuild << _T("-Windows");
#elif defined(__WXMAC__)
        wxbuild << _T("-Mac");
#elif defined(__UNIX__)
        wxbuild << _T("-Linux");
#endif

#if wxUSE_UNICODE
        wxbuild << _T("-Unicode build");
#else
        wxbuild << _T("-ANSI build");
#endif // wxUSE_UNICODE
    }

    return wxbuild;
}

BEGIN_EVENT_TABLE(wxEditorFrame, wxFrame)
    EVT_CLOSE(wxEditorFrame::OnClose)
    EVT_MENU(idMenuQuit, wxEditorFrame::OnQuit)
    EVT_MENU(idMenuAbout, wxEditorFrame::OnAbout)
    EVT_MENU(idMenuOpen, wxEditorFrame::OnOpen)
END_EVENT_TABLE()

wxEditorFrame::wxEditorFrame(wxFrame *frame, const wxString& title)
    : wxFrame(frame, -1, title)
{
#if wxUSE_MENUS
    // create a menu bar
    wxMenuBar* mbar = new wxMenuBar();
    wxMenu* fileMenu = new wxMenu(_T(""));
    fileMenu->Append(idMenuOpen, _("&Open\tAlt-F5"), _("Open a file"));
    fileMenu->Append(idMenuQuit, _("&Quit\tAlt-F4"), _("Quit the application"));
    mbar->Append(fileMenu, _("&File"));

    wxMenu* helpMenu = new wxMenu(_T(""));
    helpMenu->Append(idMenuAbout, _("&About\tF1"), _("Show info about this application"));
    mbar->Append(helpMenu, _("&Help"));

    SetMenuBar(mbar);
#endif // wxUSE_MENUS

#if wxUSE_STATUSBAR
    // create a status bar with some information about the used wxWidgets version
    CreateStatusBar(1);
    SetStatusText("Hello, it's " + wxDateTime::Now().Format("%c using " + wxbuildinfo(short_f)),0);
    //SetStatusText(wxbuildinfo(short_f), 1);
#endif // wxUSE_STATUSBAR

textControl = new wxTextCtrl(this, idTextBox,
    wxT(""), wxDefaultPosition, wxDefaultSize,
    wxTE_MULTILINE | wxTE_RICH , wxDefaultValidator, wxTextCtrlNameStr);

}

wxEditorFrame::~wxEditorFrame()
{
}

void wxEditorFrame::OnClose(wxCloseEvent &event)
{
    Destroy();
}

void wxEditorFrame::OnQuit(wxCommandEvent &event)
{
    Destroy();
}

void wxEditorFrame::OnAbout(wxCommandEvent &event)
{
    wxString msg = wxbuildinfo(long_f);
    wxMessageBox(msg, _("Welcome to..."));
}

void wxEditorFrame::OnOpen(wxCommandEvent &event)
{
    wxFileDialog *openDialog = new wxFileDialog(this, wxT("Choose a file"), wxT(""), wxT(""),
        wxT("Text Files (*.txt)|*.txt|C++ Files (*.cpp)|*.cpp|Header Files (*.h)|*.h"),
        wxFD_OPEN );

    int response = openDialog->ShowModal(); //get response from the dialog

    if(response == wxID_OK) //if response ok, then load contents into textControl
        {
            this->textControl->LoadFile(openDialog->GetPath());
        }

}

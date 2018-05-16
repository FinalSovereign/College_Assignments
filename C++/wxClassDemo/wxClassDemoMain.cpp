/***************************************************************
 * Name:      wxClassDemoMain.cpp
 * Purpose:   Code for Application Frame
 * Author:     ()
 * Created:   2017-05-22
 * Copyright:  ()
 * License:
 **************************************************************/

#ifdef WX_PRECOMP
#include "wx_pch.h"
#endif

#ifdef __BORLANDC__
#pragma hdrstop
#endif //__BORLANDC__

#include "wxClassDemoMain.h"

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

BEGIN_EVENT_TABLE(wxClassDemoFrame, wxFrame)
    EVT_CLOSE(wxClassDemoFrame::OnClose)
    EVT_MENU(idMenuQuit, wxClassDemoFrame::OnQuit)
    EVT_MENU(idMenuAbout, wxClassDemoFrame::OnAbout)
END_EVENT_TABLE()

wxClassDemoFrame::wxClassDemoFrame(wxFrame *frame, const wxString& title)
    : wxFrame(frame, -1, title)
{
#if wxUSE_MENUS
    // create a menu bar
    wxMenuBar* mbar = new wxMenuBar();
    wxMenu* fileMenu = new wxMenu(_T(""));
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

}


wxClassDemoFrame::~wxClassDemoFrame()
{
}

void wxClassDemoFrame::OnClose(wxCloseEvent &event)
{
    Destroy();
}

void wxClassDemoFrame::OnQuit(wxCommandEvent &event)
{
    Destroy();
}

void wxClassDemoFrame::OnAbout(wxCommandEvent &event)
{
    wxString msg = wxbuildinfo(long_f);
    wxMessageBox(msg, _("Welcome to..."));
}

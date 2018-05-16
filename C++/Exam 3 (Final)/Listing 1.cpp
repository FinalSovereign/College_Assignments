#include "wx/wx.h"

class MyApp: public wxApp
{
    virtual bool OnInit();
};

enum
{
    ID_Quit = 1001, ID_About, ID_TextBox, ID_Timer
};

class MyFrame: public wxFrame
{
    public:
        MyFrame(const wxString& title, const wxPoint& pos, const wxSize& size);

    void OnQuit(wxCommandEvent& event);
    void OnAbout(wxCommandEvent& event);
    void OnTimer(wxTimerEvent& event);

    wxTimer* m_timer;
    wxTextCtrl* textControl;
    wxString* MyString;

    wxString::iterator MyStringOffset;

    DECLARE_EVENT_TABLE()
};

BEGIN_EVENT_TABLE(MyFrame, wxFrame)
    EVT_MENU(ID_Quit, MyFrame::OnQuit)
    EVT_MENU(ID_About, MyFrame::OnAbout)
    EVT_TIMER(ID_Timer, MyFrame::OnTimer)
END_EVENT_TABLE()

IMPLEMENT_APP(MyApp)

bool MyApp::OnInit()
{
    MyFrame *frame = new MyFrame( _("Text Timer"), wxPoint(50, 50), wxSize(450, 340) );

    frame->Show(true);
    SetTopWindow(frame);

    return true;
}

MyFrame::MyFrame(const wxString& title, const wxPoint& pos, const wxSize& size): wxFrame( NULL, -1, title, pos, size )
{
    textControl = new wxTextCtrl(this, ID_TextBox, wxT(""), wxDefaultPosition, wxDefaultSize, wxTE_MULTILINE | wxTE_RICH, wxDefaultValidator, wxTextCtrlNameStr);

    wxMenu *menuFile = new wxMenu;

    menuFile->Append( ID_About, _("&About...") );
    menuFile->AppendSeparator();
    menuFile->Append( ID_Quit, _("&Exit") );

    wxMenuBar *menuBar = new wxMenuBar;

    menuBar->Append( menuFile, _("&File") );
    SetMenuBar( menuBar );

    MyString = new wxString ("The program timer says..         Hello World :-)   \n\n");

    MyStringOffset = MyString->begin();

    m_timer = new wxTimer (this, ID_Timer);
    m_timer->Start(100);
}

void MyFrame::OnQuit(wxCommandEvent& WXUNUSED(event))
{
    m_timer->Stop();
    Close(TRUE);
}

void MyFrame::OnAbout(wxCommandEvent& WXUNUSED(event))
{
    wxMessageBox( _("Timer with text"), _(""), wxOK | wxICON_INFORMATION, this);
}

void MyFrame::OnTimer(wxTimerEvent& event)
{
    textControl->AppendText(*MyStringOffset++);

    if(MyStringOffset == MyString->end())
        MyStringOffset = MyString->begin();
}

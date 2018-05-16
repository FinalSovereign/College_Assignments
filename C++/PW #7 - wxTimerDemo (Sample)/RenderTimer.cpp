// Render timer - use of a timer
//  http://wiki.wxwidgets.org/Making_a_render_loop
#include <wx/sizer.h>
#include <wx/wx.h>
#include <wx/timer.h>

// prototypes
class BasicDrawPane;
class MyFrame;

// class definitions
class RenderTimer : public wxTimer
{
    BasicDrawPane* pane;
public:
    RenderTimer(BasicDrawPane* pane);
    void Notify();
    void start();
};


class BasicDrawPane : public wxPanel
{

public:
    BasicDrawPane(wxFrame* parent);

    void paintEvent(wxPaintEvent& evt);
    void render( wxDC& dc );

    DECLARE_EVENT_TABLE()
};



class MyApp: public wxApp
{
    bool OnInit();

    MyFrame* frame;
public:

};


RenderTimer::RenderTimer(BasicDrawPane* pane) : wxTimer()
{
    RenderTimer::pane = pane;
}

void RenderTimer::Notify()
{
    pane->Refresh();
}

void RenderTimer::start()
{
    wxTimer::Start(10);
}

IMPLEMENT_APP(MyApp)

class MyFrame : public wxFrame
{
    RenderTimer* timer;
    BasicDrawPane* drawPane;

public:
    MyFrame() : wxFrame((wxFrame *)NULL, -1,  wxT("wxTimerDemo " + wxDateTime::Now().Format("%c")), wxPoint(50,50), wxSize(500,300))
    {

        drawPane = new BasicDrawPane( this );

        timer = new RenderTimer(drawPane);
        Show();
        timer->start();
    }
    ~MyFrame()
    {
        delete timer;
    }
    void onClose(wxCloseEvent& evt)
    {
        timer->Stop();
        evt.Skip();
    }
    DECLARE_EVENT_TABLE()
};

// event table for MyFrame
BEGIN_EVENT_TABLE(MyFrame, wxFrame)
EVT_CLOSE(MyFrame::onClose)
END_EVENT_TABLE()

bool MyApp::OnInit()
{
    frame = new MyFrame();
    frame->Show();

    return true;
}

// event table for BasicDrawPane
BEGIN_EVENT_TABLE(BasicDrawPane, wxPanel)
EVT_PAINT(BasicDrawPane::paintEvent)
END_EVENT_TABLE()



BasicDrawPane::BasicDrawPane(wxFrame* parent) :
wxPanel(parent)
{
}


void BasicDrawPane::paintEvent(wxPaintEvent& evt)
{
    wxPaintDC dc(this);
    render(dc);
}


void BasicDrawPane::render( wxDC& dc )
{
    static int y = 0;
    static int y_speed = 2;

    y += y_speed;
    if(y<0) y_speed = 2;
    if(y>200) y_speed = -2;

    dc.SetBackground( *wxWHITE_BRUSH );
    dc.Clear();
    dc.DrawText(wxT("Testing"), 40, y);
}

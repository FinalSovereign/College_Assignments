/////////////////////////////////////////////////////////////////////////////
// Name:        min06.cpp
// Purpose:     Draw a Sine wave in wxMathPlot plus log window  H. Watson
// bug fixed 20130307  HW
//  another 20160609  HW  gcc version 5.1.0
/////////////////////////////////////////////////////////////////////////////

// ============================================================================
// declarations
// ============================================================================

// ----------------------------------------------------------------------------
// headers
// ----------------------------------------------------------------------------

// For compilers that support precompilation, includes "wx/wx.h".
#include "wx/wxprec.h"

#ifdef __BORLANDC__
    #pragma hdrstop
#endif

// for all others, include the necessary headers (this file is usually all you
// need because it includes almost all "standard" wxWindows headers)
#ifndef WX_PRECOMP
    #include "wx/wx.h"
#endif


 #include "mathplot.h"
  #define MYXSIZE 800


// ----------------------------------------------------------------------------
// private classes
// ----------------------------------------------------------------------------

// Define a new application type, each program should derive a class from wxApp
class MyApp : public wxApp
{
public:
    // override base class virtuals
    // ----------------------------
    virtual bool OnInit();
};

// Define a new frame type: this is going to be our main frame
class MyFrame : public wxFrame
{
public:
    // ctor(s)
    MyFrame(const wxString& title, const wxPoint& pos, const wxSize& size);
    // event handlers
    void OnExit(wxCommandEvent& event);
    void OnOpen(wxCommandEvent& event);
    void OnTimer(wxTimerEvent& event);



private:
  //  wxTextCtrl *m_text;  // working window
    mpWindow *plotWindow;
    wxLog *mdbug_Log;   //log object
    wxTextCtrl *mdbug_text; // log container window
    wxTimer* m_timer;
    mpFXYVector *sine;
    mpLayer* l3;
    mpLayer* l2;
    mpLayer* l1;
    int counter;
    int offset;
    float pom;
    float yval;
    std::vector<double> x;
    std::vector<double> y;

// macro to establish the event table
    DECLARE_EVENT_TABLE()
};

// ============================================================================
// define Event Table ID constant definitions
// ============================================================================
    // menu items
#define    ID_Exit 10000
#define    ID_Open 10001
#define    idTimer 10002

// ============================================================================
// Event Table with connections
// ============================================================================
BEGIN_EVENT_TABLE(MyFrame, wxFrame)
    EVT_MENU(ID_Exit, MyFrame::OnExit)
    EVT_MENU(ID_Open, MyFrame::OnOpen)
    EVT_TIMER(idTimer, MyFrame::OnTimer)
END_EVENT_TABLE()





// Create a new application object
IMPLEMENT_APP(MyApp)

// ============================================================================
// implementation
// ============================================================================

// ----------------------------------------------------------------------------
// the application class
// ----------------------------------------------------------------------------

// 'Main program' equivalent: the program execution "starts" here
bool MyApp::OnInit()
{
    // create the main application window
    MyFrame *frame = new MyFrame(_T("Draw Sine Wave and Log - " + wxDateTime::Now().Format("%c")),
//        wxPoint(50, 50), wxSize(450, 340));
wxPoint(50, 50), wxDefaultSize);

    // and show it
    frame->Show(TRUE);

    // success
    return TRUE;
}

// ----------------------------------------------------------------------------
// main frame
// ----------------------------------------------------------------------------

// frame constructor
MyFrame::MyFrame(const wxString& title, const wxPoint& pos, const wxSize& Size)
       : wxFrame(NULL, -1, title, pos, Size)

{

   // CREATE MENU BAR
  wxMenu *MyMenu = new wxMenu;

    MyMenu->Append(ID_Open,"Open");
    MyMenu->Append(ID_Exit,"Exit");


  wxMenuBar *MyMenuBar = new wxMenuBar();

    MyMenuBar->Append(MyMenu,"File");

    SetMenuBar(MyMenuBar);

  // plot window
    plotWindow = new mpWindow( this, -1, wxPoint(30,30),
      wxDefaultSize, wxSUNKEN_BORDER );


   // Log Window
     mdbug_text = new wxTextCtrl(this, -1, "This is the log window.\n",
                       wxPoint(0, 250), wxDefaultSize, wxTE_MULTILINE);

     mdbug_text->SetBackgroundColour(wxT("wheat"));

     mdbug_Log = wxLog::SetActiveTarget(new wxLogTextCtrl(mdbug_text));

   // make sizer
     wxBoxSizer *topSizer = new wxBoxSizer(wxVERTICAL);

     topSizer->Add(plotWindow, 1, wxEXPAND | wxALL);

     topSizer->Add(mdbug_text, 0, wxEXPAND);

    //set the initial size of the display
    SetMinSize(wxSize(800,400));
    SetSizer(topSizer);   // actually set the sizer


    Center();


    sine = new mpFXYVector("Sine");

   pom = 0;
for(int i=0; i<1000; i++)
    {
        x.push_back(pom);
//        if (i<800)
//            y.push_back(512*sin(pom)+512);
//        else
            y.push_back(0);
        pom += 0.01;
    }

  sine->SetData(x,y);
  counter = 0;  // array index
  offset = 0;

  mpScaleX* XScale = new mpScaleX(wxT(""), mpALIGN_BORDER_BOTTOM);
          XScale->SetLabelFormat("%3.0f");
      l1= XScale;


  mpScaleY* YScale = new mpScaleY(wxT(""), mpALIGN_BORDER_LEFT);  //yaxis
          YScale->SetLabelFormat("%3.0f");
      l2 = YScale;



      l3 = sine;

    l3->SetContinuity(false);

    plotWindow->AddLayer(l1);
    plotWindow->AddLayer(l2);
    plotWindow->AddLayer(l3);


    plotWindow->Fit(0, 11, 0, 1024);



double* bbx = new double[4];
	plotWindow->GetBoundingBox(bbx);
	wxLogMessage(wxT("bounding box: X = %f, %f; Y = %f, %f"), bbx[0], bbx[1], bbx[2], bbx[3]);
	delete [] bbx;

  // start timer
     m_timer = new wxTimer(this, idTimer);
    static const int INTERVAL = 300; //milliseconds
    m_timer->Start(INTERVAL);


}  // end MyFrame::MyFrame


//void MyFrame::OnExit(wxCommandEvent& WXUNUSED(event))
void MyFrame::OnExit(wxCommandEvent& event)
{
   Destroy();
}


// OnOpen process
void MyFrame::OnOpen(wxCommandEvent& event)
{
   // add some text lines to m_text
  // m_text->AppendText("\nAdded Text");
  // *m_text << "\nMore text output" ;

}

void MyFrame::OnTimer(wxTimerEvent& event)
{


  for(int i=0; i<10; i++)
    {
        pom = 0.01*(float)counter;
         if (!(counter%100)) wxLogMessage(wxT("Coordinates: X = %f Y = %f"), pom, yval);
        sine->m_xs[counter] = pom;
        //x.erase(x.begin());
        yval = 256*sin(pom)+256 + (double)offset;
        sine->m_ys[counter] = yval;
        //y.erase(y.begin());
        if (counter++ >= 1000)
        {
          counter = 0;
          offset += 50;
          if(offset>150) offset=0;
        }
    }


     plotWindow->Refresh();

}

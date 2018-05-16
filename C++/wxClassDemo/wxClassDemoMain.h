/***************************************************************
 * Name:      wxClassDemoMain.h
 * Purpose:   Defines Application Frame
 * Author:     ()
 * Created:   2017-05-22
 * Copyright:  ()
 * License:
 **************************************************************/

#ifndef WXCLASSDEMOMAIN_H
#define WXCLASSDEMOMAIN_H

#ifndef WX_PRECOMP
    #include <wx/wx.h>
#endif

#include "wxClassDemoApp.h"

class wxClassDemoFrame: public wxFrame
{
    public:
        wxClassDemoFrame(wxFrame *frame, const wxString& title);
        ~wxClassDemoFrame();
    private:
        enum
        {
            idMenuQuit = 1000,
            idMenuAbout
        };
        void OnClose(wxCloseEvent& event);
        void OnQuit(wxCommandEvent& event);
        void OnAbout(wxCommandEvent& event);
        DECLARE_EVENT_TABLE()
};


#endif // WXCLASSDEMOMAIN_H

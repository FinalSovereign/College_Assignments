/***************************************************************
 * Name:      wxEditorMain.h
 * Purpose:   Defines Application Frame
 * Author:     ()
 * Created:   2017-05-29
 * Copyright:  ()
 * License:
 **************************************************************/

#ifndef WXEDITORMAIN_H
#define WXEDITORMAIN_H

#ifndef WX_PRECOMP
    #include <wx/wx.h>
#endif

#include "wxEditorApp.h"

class wxEditorFrame: public wxFrame
{
    public:
        wxEditorFrame(wxFrame *frame, const wxString& title);
        ~wxEditorFrame();
    private:
        enum
        {
            idMenuQuit = 1000,
            idTextBox,
            idMenuAbout
        };

        wxTextCtrl* textControl;

        void OnClose(wxCloseEvent& event);
        void OnQuit(wxCommandEvent& event);
        void OnAbout(wxCommandEvent& event);
        DECLARE_EVENT_TABLE()
};


#endif // WXEDITORMAIN_H

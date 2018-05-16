/***************************************************************
 * Name:      wxEditorApp.cpp
 * Purpose:   Code for Application Class
 * Author:     ()
 * Created:   2017-05-29
 * Copyright:  ()
 * License:
 **************************************************************/

#ifdef WX_PRECOMP
#include "wx_pch.h"
#endif

#ifdef __BORLANDC__
#pragma hdrstop
#endif //__BORLANDC__

#include "wxEditorApp.h"
#include "wxEditorMain.h"

IMPLEMENT_APP(wxEditorApp);

bool wxEditorApp::OnInit()
{
    wxEditorFrame* frame = new wxEditorFrame(0L, _("wxWidgets Application Template"));
    frame->SetIcon(wxICON(aaaa)); // To Set App Icon
    frame->Show();

    return true;
}

/***************************************************************
 * Name:      wxClassDemoApp.cpp
 * Purpose:   Code for Application Class
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

#include "wxClassDemoApp.h"
#include "wxClassDemoMain.h"

IMPLEMENT_APP(wxClassDemoApp);

bool wxClassDemoApp::OnInit()
{
    wxClassDemoFrame* frame = new wxClassDemoFrame(0L, _("wxWidgets Application Template"));
    frame->SetIcon(wxICON(aaaa)); // To Set App Icon
    frame->Show();
    
    return true;
}

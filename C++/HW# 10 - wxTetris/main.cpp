#include "main.h"
#include "Tetris.h"


IMPLEMENT_APP(MyApp)

bool MyApp::OnInit()
{
    srand(time(NULL));
    Tetris *tetris = new Tetris(wxT("Tetris " + wxDateTime::Now().Format("%c") ));
    tetris->SetClientSize(wxSize(240, 540));
    tetris->Centre();
    tetris->Show(true);

    return true;
}

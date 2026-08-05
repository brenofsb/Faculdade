#include <iostream>
using namespace std;

int main() {
    int estados[4][2] = {
        {1, 1},
        {1, 0},
        {0, 1},
        {0, 0}
    };

    cout << "P Q | Completa | Simplificada | Bloqueio | Resultado" << endl;
    cout << "------------------------------------------------------" << endl;

    for (int i = 0; i < 4; i++) {
        bool P = estados[i][0]; // token válido
        bool Q = estados[i][1]; // favorito

        bool completa = (P && Q) || (P && !Q);
        bool simplificada = P;
        bool bloqueio = !P;

        cout << P << " " << Q << " |     "
             << completa << "     |       "
             << simplificada << "       |    "
             << bloqueio << "     | ";

        if (simplificada) {
            cout << "Download liberado";
        } else {
            cout << "Download bloqueado";
        }

        cout << endl;
    }

    return 0;
}

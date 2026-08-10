#include <iostream>
using namespace std;

// Nome do workshop: Veiculo
// Dupla: Breno Borges e Matheus Bacelar
int main() {
	int estados[4][2] = {
		{1, 1},
		{1, 0},
		{0, 1},
		{0, 0}
	};

	cout << " Cinto afivelado | Motor ligado | (Cinto afivelado v ¬Cinto afivelado) ∧ Motor ligado | Q | ¬Q | Resultado" << endl;
	cout << "----------------------------------------------------------------------------------------------------------" << endl;

	for (int i = 0; i < 4; i++) {
		bool P = estados[i][0]; // cinto afivelado
		bool Q = estados[i][1]; // motor ligado

		// Permitir movimento quando o cinto esta afivelado ou nao e se o motor esta ligado
		bool completa = (P && Q) || (!P && Q);

		// Permitir movimento se o motor esta ligado
		bool simplificada = Q;

		// Bloquear movimento se o motor nao estiver ligado
		bool bloqueio = !Q;

		cout << "       " << P << "         |      " << Q << "       |                            "
		     << completa << "                        | "
		     << simplificada << " |  "
		     << bloqueio << " | ";

		if (simplificada) {
			cout << "Movimento permitido";
		} else {
			cout << "Movimento bloqueado";
		}

		cout << endl;
	}

	return 0;
}

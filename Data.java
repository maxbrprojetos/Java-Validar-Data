
public class Data {
	public int dia;
	public int mes;
	public int ano;

	private String sMensagem;
	private boolean anoBissesto = false;
	private boolean dadosValidos = false;

	private String verificarDia() {
		if (dia <= 0) {
			sMensagem = "O dia deve começar com 1. A data não começa com zero. Digite novamente.";
			dadosValidos = false;
		} else if (this.dia >= 32) {
			sMensagem = "Os dia dos meses vam de 28, 29 30 e 31. Digite novamente.";
			dadosValidos = false;
		} else if ((dia == 29) && (mes == 2) && (anoBissesto == false)) {
			sMensagem = "Não é um ano Bissesto, verifique o dia e digite novamente.";
			dadosValidos = false;
		} else if ((dia == 31) && ((mes == 4) || (mes == 6) || (mes == 9))) {
			sMensagem = "Este mês tem 30 dias, verifique a sua data, e digite novamente";
			dadosValidos = false;
		} else if ((dia == 30)
				&& ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12))) {
			sMensagem = "Este mês tem 31 dias. Digite novamente.";
			dadosValidos = false;
		} else {
			sMensagem = "Dia certo.";
			dadosValidos = true;
		}
		return sMensagem;
	}

	private String verificarMes() {
		if (this.mes <= 0) {
			sMensagem = "O mês não pode iniciar com zero";
			dadosValidos = false;
		} else if (this.mes >= 13) {
			sMensagem = "O mês não pode ultrapassar a 12.";
			dadosValidos = false;
		} else if (this.mes >= 1 && this.mes <= 12) {
			sMensagem = "O mês correto.";
			dadosValidos = true;
		}
		return sMensagem;
	}

	private String verificarAno() {
		if (this.ano <= 0) {
			sMensagem = "O ano não deve iniciar com zero.";
			dadosValidos = false;
		} else if (this.ano > 9999) {
			sMensagem = "Sistema só aceita até 4 digitos para o ano ex. 9999.";
			dadosValidos = false;
		} else if ((this.ano >= 1) && (this.ano <= 9999)) {
			dadosValidos = true;
			sMensagem = "O ano está correto";
		}
		return sMensagem;
	}

	private String verificarAnoBissesto() {
		anoBissesto = false;
		if ((this.ano >= 1) && (this.ano < 1952)) {
			sMensagem = "Não é um ano Bissesto.";
			anoBissesto = false;
		} else if (this.ano % 400 == 0) {
			sMensagem = "O ano é Bissesto.";
			anoBissesto = true;
		} else if ((this.ano % 4 == 0) && (this.ano % 100 != 0)) {
			sMensagem = "O ano é Bissesto.";
			anoBissesto = true;
		}
		dadosValidos = true;
		return sMensagem;
	}

	public String formatada() {
		String sDia = "";
		String sMes = "";
		String sAno = "";
		String sData;

		sDia = Integer.toString(this.dia);
		sMes = Integer.toString(this.mes);
		sAno = Integer.toString(this.ano);

		if (this.dia <= 9) {
			sDia = "0" + sDia;
		}

		if (this.mes <= 9) {
			sMes = "0" + sMes;
		}

		if ((this.ano >= 1) && (this.ano <= 9)) {
			sAno = "000" + sAno;
		}

		if ((this.ano >= 10) && (this.ano <= 99)) {
			sAno = "00" + sAno;
		}

		if ((this.ano >= 100) && (this.ano <= 999)) {
			sAno = "0" + sAno;
		}

		sData = sDia + "/" + sMes + "/" + sAno;
		return sData;
	}

	public boolean validarData() {
		dadosValidos = false;
		verificarAno();

		if (dadosValidos == true) {
			dadosValidos = false;

			verificarAnoBissesto();
			if (dadosValidos == true) {
				dadosValidos = false;

				verificarMes();
				if (dadosValidos == true) {
					dadosValidos = false;

					verificarDia();
					if (dadosValidos == true) {
						formatada();
					}
				}
			}
		}
		return dadosValidos;
	}

}

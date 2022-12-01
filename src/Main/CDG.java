package Main;

import cdg.gui.cdglogin;

/**
 * @author CMSdev
 **/

public class CDG {

	public static void main(String[] args) {
		new CDG().iniciarTela();

	}

	private void iniciarTela() {
		cdglogin frame = new cdglogin();
		frame.setVisible(true);
	}
}
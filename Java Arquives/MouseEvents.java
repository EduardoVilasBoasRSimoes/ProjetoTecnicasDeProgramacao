import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEvents implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) { //Caso o usu�rio clique na tela com o mouse, essa fun��o ser� chamada
		System.out.println("Alguem est� tentando atrapalhar a luta...");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) { //Caso o usu�rio entre na tela com o cursor do mouse, essa fun��o ser� chamada
		System.out.println("Pode entrar, mas nao atrapalhe por favor...");
	}

	@Override
	public void mouseExited(MouseEvent e) { //Caso o usu�rio saia da tela com o mouse, essa fun��o ser� chamada          
		System.out.println("Obrigado!");
	}

}

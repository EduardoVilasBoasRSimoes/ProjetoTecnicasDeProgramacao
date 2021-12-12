import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEvents implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) { //Caso o usuário clique na tela com o mouse, essa função será chamada
		System.out.println("Alguem está tentando atrapalhar a luta...");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) { //Caso o usuário entre na tela com o cursor do mouse, essa função será chamada
		System.out.println("Pode entrar, mas nao atrapalhe por favor...");
	}

	@Override
	public void mouseExited(MouseEvent e) { //Caso o usuário saia da tela com o mouse, essa função será chamada          
		System.out.println("Obrigado!");
	}

}

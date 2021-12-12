import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Desenho implements Runnable {
	
	private int x;
	private int y;
	private int code;  //Atributo acrescentado para indicar a cena da animação

	private BufferedImage img;
	private Thread t = new Thread(this);
	
	public Desenho() {
		t.start();
	}
	
	public Desenho(int x, int y, String path, int code) {
		this.setImg(path);
		this.setX(x);
		this.setY(y);
		this.setCode(code); //Atributo acrescentado no construtor
		t.start();
	}

	public void run() {
		int i = 0;
		if(this.getCode() == 1){                    
			while(this.getX() != -50) {
				
				try {                                  //Bloco referente a cena 1
					t.sleep(8);          
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				moverEsquerda();
				
			}
		} else if (this.getCode() == 2) {
			
			while(this.getX() != 20) {
				try {                                  //Bloco referente a cena 2
					t.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverDireita();
			}
				
		} else if (this.getCode() == 3) {
			
			while(this.getX() != 50) {
				try {                                   //Bloco referente a cena 3
					t.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverDireita();
			}
		} else if (this.getCode() == 4) {
			
			while(this.getX() != 60) {
				try {                                   //Bloco referente a cena 4
					t.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverDireita();
			}
		}  else if (this.getCode() == 5) {
			
			while(this.getX() != 90) {
				try {                                   //Bloco referente a cena 5
					t.sleep(4500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverDireita();
			}
		} else if (this.getCode() == 6) {
			
			while(true) {
				try {                                   //Bloco referente a cena 6
					t.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverDireita();
			}
		} 
	}
	
	public void moverDireita() {
		x = x + 10;
	}
	
	public void moverEsquerda() {    //Método acrescentado para mover a imgaem para esquerda
		x = x - 10;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getImg() {
		return img;
	}
	
	public int getCode() {
		return code;
	}                                    //Getters e setters do  novo atributo

	public void setCode(int code) {
		this.code = code;
	}

	public void setImg(String path) {
		File fileImg = new File(path);
		try { img = ImageIO.read(fileImg); }
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void desenhar(Graphics g) throws ExcederLimiteException {  //throws da exceção criada
		//Desenhando a imagem na tela
		g.drawImage(this.getImg(), this.getX(), this.getY(), null);
		if(this.getX() >= 2000 || this.getX() <= -4000) {             //Caso esses limites sejam ultrapassados, a exceção será lançada
			throw new ExcederLimiteException();
		} 
	}
}


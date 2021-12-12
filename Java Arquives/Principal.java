import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO.
//QUALQUER ALTERACAO REALIZADA DEVE OBEDECER A HIERARQUIA

public class Principal extends JFrame {
	
	File arquivo = new File ("C:\\Users\\eddso\\eclipse-workspace\\Projeto_V2\\Luta.txt"); 
	FileOutputStream fos;
	DataOutputStream dos;   //Objetos responsáveis pela escrita e leitura do arquivo
	FileInputStream fis;
	DataInputStream dis;                                                                  
	
	int I = 0;             //Variavel auxiliar para leitura de arquivo
	
	private Desenho goku;
	private Desenho parado;
	private Desenho ssj0;
	private Desenho ssj1;
	private Desenho ssj2;
	private Desenho ssj3;
	private Desenho kame;
	private Desenho vegeta;         //Objetos da classe Desenho para formar a animação na Jframe
	private Desenho vegetaParado;
	private Desenho vegetaSsj0;
	private Desenho vegetaSsj1;
	private Desenho vegetaFall;
	private Desenho vegetaHurt;
	private Desenho vegetaLeave;
	private Desenho w;
	private Desenho w2;
	private static final long serialVersionUID = 1L;

	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Desenhando a tela e seus elementos
		goku = new Desenho(1350, 250, "voando.png", 1);
		parado = new Desenho(10, 250, "GokuStand.png", 2);
		ssj0 = new Desenho(40, 250, "ssj.png", 3);
		ssj1 = new Desenho(50, 250, "ssj 1.png", 4);
		ssj2 = new Desenho(80, 250, "ssj 2.png", 5);
		ssj3 = new Desenho(170, 250, "kamepose.png", 0);
		kame = new Desenho(-3300, 230, "kame.png", 6);
		vegeta = new Desenho(1700, 250, "vegetaV.png", 1);          // Dando valores aos atributos dos objetos da classe Desenho
		vegetaParado = new Desenho(200, 240, "VegetaStand.png", 2);
		vegetaSsj0 = new Desenho(250, 240, "VegetaSsj.png", 3);
		vegetaSsj1 = new Desenho(260, 240, "VegetaSsj1.png", 4);
		vegetaFall = new Desenho(290, 240, "VegetaFall.png", 5);
		vegetaHurt = new Desenho(450, 240, "VegetaHurt.png", 0);
		vegetaLeave = new Desenho(-1750, 240, "VegetaFall.png", 6);
		w = new Desenho(0, 220, "white.png", 0);
		w2 = new Desenho(-80, 220, "white1.png", 0);
	}
	
	public void escreverArquivo() {
		try {
			fos = new FileOutputStream(arquivo);
			dos = new DataOutputStream(fos);
			dos.writeUTF("Vegeta esta perseguindo Goku com toda velocidade!\n"
					+ "Goku e Vegeta estao se encarando... Uma grande batalha esta para acontecer!\n" //Função para escrita no arquivo
					+ "Comecou! Ambos se golpeiam ferozmente!\n"
					+ "Eles possuem o mesmo nivel de luta!\n"
					+ "Vegeta foi acertado!\n"
					+ "Goku lancou um Kame-hame-ha!");
			dos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			System.out.println("Erro de entrada ou saida!");
		}
	}
	
	public void lerArquivo() {
		int cont = 0;
		try {
			fis = new FileInputStream(arquivo);
			dis = new DataInputStream(fis);
			String frase;
			while((frase = dis.readLine()) != null) {
				if(cont > I) {
					System.out.println(frase);
					break;                                //Função para leitura em arquivo, a qual acontecerá linha por linha,
				}                                         // o que se dará pelo auxilio da variável I.
				cont++;
			}
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			System.out.println("Erro de entrada ou saida!");
		}
	}
	
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		try {
			while(goku.getX() != -50) {
				goku.desenhar(g2);              // Primeira cena da animação
				vegeta.desenhar(g2);
			}
			lerArquivo();                       // Leitura da primeira linha
			I++;
			w.desenhar(g2);
			while(parado.getX() != 20) {
				parado.desenhar(g2);            // Segunda cena da animação
				vegetaParado.desenhar(g2);
			}
			lerArquivo();                       // Leitura da segunda linha
			I++;
			w.desenhar(g2);
			while(ssj0.getX() != 50) {
				ssj0.desenhar(g2);              // Terceira cena da animação
				vegetaSsj0.desenhar(g2);
			}
			lerArquivo();                       // Leitura da terceira linha
			I++;
			w.desenhar(g2);
			while(ssj1.getX() != 60) {          
				ssj1.desenhar(g2);              // Quarta cena da animação
				vegetaSsj1.desenhar(g2);
			}
			lerArquivo();                       // Leitura da quarta linha
			I++;
			w.desenhar(g2);
			while(ssj2.getX() != 90) {
				ssj2.desenhar(g2);              // Quinta cena da animação
				vegetaFall.desenhar(g2);
			}
			if(kame.getX() <= -1200) {
				vegetaHurt.desenhar(g2);			 
			} else { 
				vegetaLeave.desenhar(g2);
			}
			kame.desenhar(g2);
			w2.desenhar(g2);                    // Sexta cena da animação
			ssj3.desenhar(g2);
			lerArquivo();                       // Leitura da quinta linha
			I++;
		} catch(ExcederLimiteException e) {
			System.out.println("Alguma imagem excedeu o limite");    //Aplicação da exceção que é lançada caso alguma imagem passe de um certo limite para esquerda ou direita
			e.printStackTrace();
			this.dispose();                                          //Quando a exceção é lançada, o jframe é fechado
		}
	}
	
	
	public static void main(String[] args) {
		//Criando uma instancia da classe principal
		Principal t = new Principal();
		t.getContentPane().addMouseListener(new MouseEvents()); // Linha para acrescentar os eventos de mouse
		t.setSize(1300, 750);
		t.createBufferStrategy(1);		
		t.setVisible(true);
		t.createBufferStrategy(2);
	}
	
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost()) getBufferStrategy().show();
	    Graphics g = getBufferStrategy().getDrawGraphics();
	    //Criando um contexto grafico
	    Graphics g2 = g.create();
	    //Limpando a tela
	    g2.setColor(Color.WHITE);        
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    renderizarImagens(g2);
	    //Liberando os contextos criados
	    g.dispose(); 
	    g2.dispose();
	}

	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
	}
}
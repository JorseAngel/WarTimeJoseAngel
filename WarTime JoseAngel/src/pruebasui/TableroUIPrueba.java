package pruebasui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Juego;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Tablero;
import modelo.Tipo;
import vista.TableroUI;
import vista.info.TableroUIInfo;

public class TableroUIPrueba extends JFrame {

	private JPanel contentPane;
	private TableroUI tableroUI;
	private Juego juego = new Juego();
	TableroUIInfo tableroUIInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUIPrueba frame = new TableroUIPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableroUIPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JPanel panel = (JPanel) e.getSource();
				Coordenada coordenadaActual = getCoordenada(panel.getName());

				if (getListaEjercitoUno().size() > 0) {
					Batallon batallon = getListaEjercitoUno().get(0);
					getTablero().insertar(batallon, coordenadaActual);
					getListaEjercitoUno().remove(0);
				} else if (getListaEjercitoDos().size() > 0) {
					Batallon batallon = getListaEjercitoDos().get(0);
					getTablero().insertar(batallon, coordenadaActual);
					getListaEjercitoDos().remove(0);
				}
				tableroUI.actualizarTablero(tableroUIInfo);
			}
		};
		
		tableroUIInfo = new TableroUIInfo(juego.getTablero());
		tableroUI = new TableroUI(6, 12, mouseAdapter, tableroUIInfo);
		contentPane.add(tableroUI, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
//		Tablero tablero=new Tablero(new Dimension(6, 12));
//		tablero.insertar(new Batallon(4, Tipo.arqueria), new Coordenada(4, 4));
//		TableroUIInfo tableroUIInfo=new TableroUIInfo(tablero);
//		tableroUI = new TableroUI(6, 12, new MouseAdapter() {
//		},tableroUIInfo);
//		contentPane.add(tableroUI, BorderLayout.CENTER);
//		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	private Coordenada getCoordenada(String panelName) {
		return new Coordenada(panelName.charAt(0), panelName.charAt(1));
	}

	private LinkedList<Batallon> getListaEjercitoUno() {
		return juego.getEjercitoUno().getGroup();
	}

	private LinkedList<Batallon> getListaEjercitoDos() {
		return juego.getEjercitoDos().getGroup();
	}
	
	private Tablero getTablero() {
		return juego.getTablero();
	}
}

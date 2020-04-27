package control;

import java.awt.Color;
import java.util.LinkedList;

import modelo.Batallon;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Soldado;
import modelo.Tablero;
import modelo.Tipo;

public class Juego {
	private Tablero tablero;
	private Dimension dimension = new Dimension(6, 12);
	private LinkedList<Batallon> batallonesJugadorUno = new LinkedList<Batallon>();
	private Ejercito ejercitoUno = new Ejercito(0);
	private LinkedList<Batallon> batallonesJugadorDos = new LinkedList<Batallon>();
	private Ejercito ejercitoDos = new Ejercito(1);

	public Juego() {
		super();
		tablero = new Tablero(dimension);
		crearBatallones(Color.GREEN, Color.RED, batallonesJugadorUno);
		ejercitoUno.setGroup(batallonesJugadorUno);
		crearBatallones(Color.RED, Color.GREEN, batallonesJugadorDos);
		ejercitoDos.setGroup(batallonesJugadorDos);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Ejercito getEjercitoUno() {
		return ejercitoUno;
	}

	public Ejercito getEjercitoDos() {
		return ejercitoDos;
	}
	
	private void crearBatallones(Color miColor, Color suColor, LinkedList<Batallon> batallonJugador) {
		int numeroSoldados = 10;
		Color colorArmy = miColor;
		Color colorEnemigo = suColor;
		int tiposBatallon = 2;
		int idBatallon = 0;
		
		LinkedList<Soldado> batallonInfanteria = new LinkedList<Soldado>();
		for (int i = 0; i < numeroSoldados; i++) {
			if (i < (numeroSoldados/2)) {
				batallonInfanteria.add(new Soldado(Especialidad.espada));
			} else {
				batallonInfanteria.add(new Soldado(Especialidad.lanza));
			}
		}
		for (int i = 0; i < tiposBatallon; i++) {
			Batallon batallon = new Batallon(idBatallon, Tipo.infanteria, batallonInfanteria, colorEnemigo,
					colorArmy);
			batallonJugador.add(batallon);
			idBatallon += 1;
		}
		
		
		LinkedList<Soldado> batallonArqueria = new LinkedList<Soldado>();
		for (int i = 0; i < numeroSoldados; i++) {
			if (i < (numeroSoldados/2)) {
				batallonArqueria.add(new Soldado(Especialidad.arco));
			} else {
				batallonArqueria.add(new Soldado(Especialidad.ballesta));
			}
		}
		for (int i = 0; i < tiposBatallon; i++) {
			Batallon batallon = new Batallon(idBatallon, Tipo.arqueria, batallonArqueria, colorEnemigo,
					colorArmy);
			batallonJugador.add(batallon);
			idBatallon += 1;
		}
		
		
		LinkedList<Soldado> batallonCaballeria = new LinkedList<Soldado>();
		for (int i = 0; i < numeroSoldados; i++) {
			if (i < (numeroSoldados/2)) {
				batallonCaballeria.add(new Soldado(Especialidad.ligera));
			} else {
				batallonCaballeria.add(new Soldado(Especialidad.pesada));
			}
		}
		for (int i = 0; i < tiposBatallon; i++) {
			Batallon batallon = new Batallon(idBatallon, Tipo.caballeria, batallonCaballeria, colorEnemigo,
					colorArmy);
			batallonJugador.add(batallon);
			idBatallon += 1;
		}
	}
}

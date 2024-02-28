package uo.mp.minesweeper.ranking;

import java.util.Date;

import uo.mp.minesweeper.session.GameLevel;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class GameRankingEntry {
	
	
	private String userName;
	private Date date;
	private GameLevel level;
	private long duration;
	private boolean hasWon;
	
	
	
	
	public GameRankingEntry(String userName, GameLevel level, long duration,boolean hasWon) {
		setUserName(userName);
		setLevel(level);
		setDuration(duration);
		setHasWon(hasWon);
		setDate();
	}

	/**
	 * Establece el userName del usuarion
	 * @param userName
	 */
	private void setUserName(String userName) {
		ArgumentChecks.isTrue(userName!=null,"Usuario null");
		ArgumentChecks.isTrue(!userName.isBlank() || !userName.isEmpty(),"usuario invalido");
		this.userName = userName;
	}
	/**
	 * Establece la fecha
	 * @param date
	 */
	private void setDate() {
		this.date = new Date();
	}
	
	/**
	 * Establece el parametro dificultad
	 * @param level
	 */
	private void setLevel(GameLevel level) {
		ArgumentChecks.isTrue(level!=null,"dificultad invalida");
		this.level = level;
	}
	
	/**
	 * Establece el tiempo que duro la partida
	 * @param duration
	 */
	private void setDuration(long duration) {
		ArgumentChecks.isTrue(duration>=0,"Tiempo negativo");
		this.duration = duration;
	}
	
	/**
	 * Establece si ha ganado o no
	 * @param hasWon
	 */
	private void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}

	/**
	 * Devuelve el usuario
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Devuelve la fecha
	 * @param date de tipo Date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Devuelve la dificultad del juego
	 * @return level de tipo GameLevel
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * Devuelve la duracion
	 * @return duartion
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Devulve true si ha ganado, false en caso contrario
	 * @return boolean value
	 */
	public boolean isHasWon() {
		return hasWon;
	}
	
	/**
	 * Devuelve la informacion del objeto en una cadena Stringg
	 * @param string with the object info
	 */
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(userName+" \t");
		sb.append(String.format("%td/%<tm/%<tY", date)+"\t");
		sb.append(String.format("%tH:%<tM",date)+"\t");
		sb.append(level+"\t");
		sb.append(victoria()+"  ");
		sb.append(duration);
		return sb.toString();
	}
	
	private String victoria() {
		if(hasWon) {
			return "Victoria";
		}else {
			return "Derrota";
		}
	}
	
	/**
	 * Clona el objeto
	 * @return GameRankingEntry clone
	 */
	
	public GameRankingEntry clone() {
		GameRankingEntry clone =  new GameRankingEntry(this.userName, 
								this.level, this.duration, this.hasWon);
		clone.date=this.date;
		return clone;
	}
}


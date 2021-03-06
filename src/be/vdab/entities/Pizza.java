package be.vdab.entities;

import java.math.BigDecimal;

public class Pizza {
	private long id;
	private boolean pikant;
	private String naam;
	private BigDecimal prijs;
	public Pizza(String naam, BigDecimal prijs, boolean pikant) {
		setNaam(naam);
		setPrijs(prijs);
		setPikant(pikant);
	}
	public long getId() {
		return id;
	}
	public boolean isPikant() {
		return pikant;
	}
	public String getNaam() {
		return naam;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public Pizza(long id, String naam, BigDecimal prijs, boolean pikant) {
		this(naam, prijs, pikant); // vorige constructor oproepen
		setId(id);
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPikant(boolean pikant) {
		this.pikant = pikant;
	}
	public static boolean isNaamValid(String naam) { // Deze static function
		// valideert de naam zonder een Pizza instance te moeten maken (zie verder)
		return naam != null && ! naam.trim().isEmpty();
	}
	public void setNaam(String naam) {
		if ( ! isNaamValid(naam)) {
		throw new IllegalArgumentException();
		}
		this.naam = naam;
	}
	public static boolean isPrijsValid(BigDecimal prijs) {
		return prijs != null && prijs.compareTo(BigDecimal.ZERO) >= 0;
	}
	public void setPrijs(BigDecimal prijs) {
		if ( ! isPrijsValid(prijs)) {
		throw new IllegalArgumentException();
		}
		this.prijs = prijs;
	}
}
package logica;

public class Evaluacion {

	//Atributos
	
	/**
	 * Arreglo de enunciados
	 */
	private String enunciados[] = {"Las multas se clasifican en culturales y econ�micas","La multa tipo 1 son 4 salarios m�nimos. ",
			"La multa tipo 2 son 6 salarios m�nimos.", "La multa tipo 3 son 16 salarios m�nimos. ",
			"La multa tipo 4 son 30 salarios m�nimos.","La contaminaci�n visual es una multa especial.",
			"Una de las consecuencias por el no pago de una multa durante 6 meses, es contratar o renovar contrato con "
			+ "cualquier entidad del estado.",
			"La remoci�n es la orden que se le da al propietario o responsable de los objetos,  de removerlos por concepto de la"
			+ " autoridad policial as� estos no contrar�en las normas de convivencia.",
			"La reparaci�n de da�os materiales por perturbaci�n a la posesi�n y tenencia de inmuebles o muebles es la orden del "
			+ "tesorero por medio de la cual se exige a una persona, reparar un da�o material causado en un bien inmueble o mueble"
			+ ", sin perjuicio de los procedimientos y las acciones civiles a las que haya lugar. ",
			"La primera medida correctiva es una amonestaci�n. ", "Una de las medidas correctivas no consiste en la participaci�n "
			+ "en programa comunitario o actividad pedag�gica de convivencia.  ",
			"La participaci�n en programa comunitario o actividad pedag�gica se convivencia puede ser hasta de 6 horas.",
			"La expulsi�n de domicilio consiste en expulsar del domicilio por solicitud de su morador, poseedor o tenedor, a quien"
			+ " reside en el mismo, por su voluntad, y que no haya ingresado bajo su consentimiento, haya permanecido gratuitamente"
			+ " y no tenga derecho leg�timo de permanecer en �l. ", "Decomiso es la privaci�n de manera temporal de la tenencia o la "
			+ "propiedad de bienes muebles no sujetos a registro, utilizados por una persona en comportamientos contrarios a"
			+ " las normas de convivencia, mediante acto motivado.","Los medios de polic�a se clasifican en inmateriales y materiales."
			,"Un medio de polic�a inmaterial es el permiso excepcional.",
			"Un medio de polic�a inmaterial es el registro.","Un medio de polic�a material es el la mediaci�n policial.",
			"Un medio de polic�a material es el uso de la fuerza.","Impedir el ingreso o salida prioritaria a mujer embarazada, "
			+ "adulto mayor, persona con ni�os o ni�as, o personas con discapacidad, es uno de los comportamientos que contrar�an "
			+ "la convivencia en los medios de transporte.", "Obstruir por cualquier medio la ciclo ruta o carril exclusivo para "
			+ "las bicicletas es uno de los comportamientos que atentan contra la vida e integridad de los usuarios de bicicletas.",
			"Arrinconar, obstruir, o dificultar la libre movilidad del usuario de bicicletas no es uno de los comportamientos que "
			+ "atentan contra la vida e integridad de los usuarios de bicicletas.","Obstruir por cualquier medio la ciclo ruta o "
			+ "carril exclusivo para las bicicletas, tiene una multa de tipo 2.","Arrinconar, obstruir, o dificultar la "
			+ "libre movilidad del usuario de bicicletas tiene una multa de tipo 1.", "Incumplir las disposiciones para el albergue"
			+ " de animales es uno de los comportamientos que no ponen en riesgo la convivencia por la tenencia de animales.",
			"Re�ir, incitar o incurrir en confrontaciones violentas que puedan derivar en agresiones f�sicas es uno de los "
			+ "comportamientos que atentan contra la vida y la integridad.","Arrojar en las redes de alcantarillado, acueducto y"
			+ " de aguas lluvias, cualquier objeto, sustancia, residuo, escombros, lodo, combustibles o lubricantes, que alteren u "
			+ "obstruyan el normal funcionamiento, es causante de adquirir una multa general tipo 3.","Prender o manipular fuego, "
			+ "sustancias combustibles o mercanc�as peligrosas en medio de transporte p�blico. Tiene como medida correctiva una "
			+ "multa General tipo 4. Destrucci�n de bien.","Consumir sustancias alcoh�licas, psicoactivas o prohibidas, no"
			+ " autorizados para su consumo, no tiene ning�n tipo de multa.","Consumir bebidas alcoh�licas, drogas o sustancias "
			+ "prohibidas, dentro de la instituci�n o centro educativo, es uno de los comportamientos que afectan la convivencia"
			+ " en los establecimientos educativos relacionados con consumo de sustancias."};
	
	/**
	 * Arreglo de respuestas
	 */
	private String respuestas[] = {"Falso","Verdadero","Falso","Verdadero","Falso", "Verdadero","Verdadero","Falso",
			"Falso","Verdadero","Falso","Verdadero","Falso","Falso","Verdadero", "Verdadero","Falso", "Verdadero","Verdadero", 
			"Verdadero","Verdadero", "Falso","Falso","Verdadero","Falso","Verdadero","Falso","Verdadero","Falso","Verdadero"};

	public String getEnunciado(int indice) {
		return enunciados[indice];
	}

	public void setEnunciados(String[] enunciados) {
		this.enunciados = enunciados;
	}

	public String getRespuesta(int indice) {
		return respuestas[indice];
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}
}

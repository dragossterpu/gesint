package ro.per.online.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ro.per.online.persistence.entities.enums.RoleEnum;

/**
 * Adaptador para el enum RoleEnum.
 * 
 * @see ro.per.online.persistence.entities.enums.RoleEnum
 * 
 * @author STAD
 *
 */
@Converter(autoApply = true)
public class RoleEnumAdapter implements AttributeConverter<RoleEnum, String> {

	/**
	 * Método que recibe un valor RoleEnum y devuelve su nombre.
	 */
	@Override
	public String convertToDatabaseColumn(final RoleEnum role) {
		String nombre = null;
		if (role != null) {
			nombre = role.name();
		}
		return nombre;
	}

	/**
	 * Método que recibe un nombre y devuelve su correspondiente RoleEnum.
	 */
	@Override
	public RoleEnum convertToEntityAttribute(final String dbData) {
		return RoleEnum.valueOf(dbData);
	}

}

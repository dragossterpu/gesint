package ro.stad.online.gesint.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ro.stad.online.gesint.persistence.entities.enums.RolEnum;

/**
 * Adaptor pentru enumerul RolEnum.
 * 
 * @author STAD
 *
 */
@Converter(autoApply = true)
public class RolEnumAdaptor implements AttributeConverter<RolEnum, String> {

        /**
         * Metoda care primește o valoare RolEnum și îi returnează numele.
         * @param RolEnum role
         * @return String nume
         */
        @Override
        public String convertToDatabaseColumn(final RolEnum role) {
                String nume = null;
                if (role != null) {
                        nume = role.name();
                }
                return nume;
        }

        /**
         * Metoda care primește un nume și returnează rolul corespunzător.
         * @param dbData String
         * @return RolEnum
         */
        @Override
        public RolEnum convertToEntityAttribute(final String dbData) {
                return RolEnum.valueOf(dbData);
        }

}

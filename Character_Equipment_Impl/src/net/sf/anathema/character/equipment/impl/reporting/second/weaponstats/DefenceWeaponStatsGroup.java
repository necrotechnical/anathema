package net.sf.anathema.character.equipment.impl.reporting.second.weaponstats;

import net.sf.anathema.character.equipment.impl.reporting.second.stats.AbstractValueEquipmentStatsGroup;
import net.sf.anathema.character.generic.character.IGenericCharacter;
import net.sf.anathema.character.generic.equipment.weapon.IWeapon;
import net.sf.anathema.character.generic.traits.types.AttributeType;
import net.sf.anathema.character.generic.type.CharacterType;
import net.sf.anathema.lib.resources.IResources;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;

public class DefenceWeaponStatsGroup extends AbstractValueEquipmentStatsGroup<IWeapon> {

  private final IGenericCharacter character;

  public DefenceWeaponStatsGroup(IResources resources, IGenericCharacter character) {
    super(resources, "Defence"); //$NON-NLS-1$
    this.character = character;
  }

  public int getColumnCount() {
    return 2;
  }

  public void addContent(PdfPTable table, Font font, IWeapon weapon) {
    if (weapon == null) {
      table.addCell(createEmptyValueCell(font));
      table.addCell(createFinalValueCell(font));
    }
    else {
      table.addCell(createEquipmentValueCell(font, weapon.getDefence()));
      if (weapon.getDefence() == null) {
        table.addCell(createFinalValueCell(font, (Integer) null));
      }
      else {
        double finalValue = calculateFinalValue(
            weapon.getDefence(),
            character.getTrait(AttributeType.Dexterity),
            character.getTrait(weapon.getTraitType()));
        boolean isMortal = character.getTemplate().getTemplateType().getCharacterType() == CharacterType.MORTAL;
        if (isMortal) {
          finalValue = Math.floor(finalValue / 2);
        }
        else {
          finalValue = Math.ceil(finalValue / 2);
        }
        table.addCell(createFinalValueCell(font, (int) finalValue));
      }
    }
  }
}
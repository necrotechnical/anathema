package net.sf.anathema.dummy.character;

import net.sf.anathema.character.generic.caste.ICasteType;
import net.sf.anathema.lib.util.Identificate;

public class DummyCasteType extends Identificate implements ICasteType {

  public DummyCasteType() {
    this("DummyCaste"); //$NON-NLS-1$
  }

  public DummyCasteType(String id) {
    super(id);
  }
}
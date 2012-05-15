package net.sf.anathema.charmentry.presenter.view;

import net.sf.anathema.character.library.removableentry.presenter.IRemovableEntriesView;
import net.sf.anathema.character.library.removableentry.presenter.IRemovableEntryView;
import net.sf.anathema.framework.presenter.view.IButtonControlledObjectSelectionView;
import net.sf.anathema.lib.gui.dialog.core.IPageContent;
import net.sf.anathema.lib.util.IIdentificate;

import javax.swing.Icon;
import javax.swing.ListCellRenderer;

public interface IKeywordView extends IRemovableEntriesView<IRemovableEntryView>, IPageContent {

  public IButtonControlledObjectSelectionView<IIdentificate> addObjectSelectionView(
      ListCellRenderer renderer,
      String label,
      Icon icon);
}
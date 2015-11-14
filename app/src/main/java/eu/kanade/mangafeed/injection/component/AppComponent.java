package eu.kanade.mangafeed.injection.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import eu.kanade.mangafeed.data.services.DownloadService;
import eu.kanade.mangafeed.data.services.LibraryUpdateService;
import eu.kanade.mangafeed.injection.module.AppModule;
import eu.kanade.mangafeed.injection.module.DataModule;
import eu.kanade.mangafeed.ui.catalogue.CataloguePresenter;
import eu.kanade.mangafeed.ui.download.DownloadPresenter;
import eu.kanade.mangafeed.ui.library.LibraryPresenter;
import eu.kanade.mangafeed.ui.manga.MangaPresenter;
import eu.kanade.mangafeed.ui.manga.chapter.ChaptersPresenter;
import eu.kanade.mangafeed.ui.manga.info.MangaInfoPresenter;
import eu.kanade.mangafeed.ui.reader.ReaderPresenter;
import eu.kanade.mangafeed.ui.catalogue.SourcePresenter;
import eu.kanade.mangafeed.sources.base.Source;
import eu.kanade.mangafeed.ui.reader.ReaderActivity;
import eu.kanade.mangafeed.ui.preference.SettingsAccountsFragment;
import eu.kanade.mangafeed.ui.preference.SettingsDownloadsFragment;

@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class
        }
)
public interface AppComponent {

    void inject(LibraryPresenter libraryPresenter);
    void inject(MangaPresenter mangaPresenter);
    void inject(SourcePresenter sourcePresenter);
    void inject(CataloguePresenter cataloguePresenter);
    void inject(MangaInfoPresenter mangaInfoPresenter);
    void inject(ChaptersPresenter chaptersPresenter);
    void inject(ReaderPresenter readerPresenter);
    void inject(DownloadPresenter downloadPresenter);

    void inject(ReaderActivity readerActivity);
    void inject(SettingsAccountsFragment settingsAccountsFragment);
    void inject(SettingsDownloadsFragment settingsDownloadsFragment);

    void inject(Source source);

    void inject(LibraryUpdateService libraryUpdateService);
    void inject(DownloadService downloadService);

    Application application();

}
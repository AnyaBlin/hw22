package ann.blin.tests.VTB;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class VTBTests extends TestBase {


    @Test
    @AllureId("6936")
    @Feature("Открываем страницы ВТБ и проверяем контент")
    public void testsForVTBOpenPagesAndCheckContent() {

        step("Открываем главную страницу ВТБ", () -> {
            open(VTBPages.VTBMainPage);
            step("Проверяем, что шапка содержит элемент" + VTBPages.OnlineService, () -> {
                VTBPages.checkResultsVTBMainPage();
            });
            step("Переходим на вкладку `Крупный бизнес` и проверяем содержание вкладки " + VTBPages.VTBCapital, () -> {
                VTBPages.goToTheCorporateBusinessTabAndGoToTheVTBCapitalTab();
                step("Проверяем вкладку на содержание текста " + VTBPages.VTBCapitalText, () -> {
                    VTBPages.checkResultsVTBCapitalTab();
                });
            });
            step("Переходим на вкладку" + VTBPages.VTBInsurance, () -> {
                VTBPages.goToTheCorporateBusinessTabAndGoToTheVTBInsurance();
                step("Проверяем вкладку на содержание текста " + VTBPages.VTBInsuranceText, () -> {
                    VTBPages.checkResultsVTBInsurance();
                });
            });
            step("Переходим на вкладку" + VTBPages.VTBFactoring, () -> {
                VTBPages.goToTheCorporateBusinessTabAndGoToTheVTBFactoring();
                step("Проверяем вкладку на содержание текста " + VTBPages.VTBFactoring, () -> {
                    VTBPages.checkResultsVTBFactoring();
                });
            });
        });
    }

    @Test
    @AllureId("6938")
    @Feature("Заполнение конвертера валют и проверка содержимого при нажатии кнопки Рассчитать")
    public void openPaymentPageFillСurrencyConverterAndCheckButtonCalculate() {

        step("Открываем главную страницу и переходим в `Платежи и Переводы`", () -> {
            VTBPages.goToThePaymentPage();
        });
        Allure.step("Переходим на страницу `Обмен валюты`", () ->
                VTBPages.goToTheCurrencyExchangePage());
        step("Выбираем способ обмена", () -> {
            VTBPages.chooseNonCashMethodOfExchange();
        });
        step("Заполняем конвертер валют и жмём кнопку 'Рассчитать' ", () -> {
            VTBPages.fillCurrencyConverterAndClickButtonCalculate();
        });
        step("Проверяем содержимое кнопки " + VTBPages.calculate, () -> {
            VTBPages.checkResultsAfterClickingOnButtonCalculate();
        });


        Allure.step("Нажимаем на кнопку `Найти отделение`", () ->
                VTBPages.clickButtonSearchOffice());
        step("Проверяем, что страница содержит элемент" + VTBPages.OfficesAndATMs, () ->
                VTBPages.checkResultsAfterClickingOnButtonSearchOffice());
    }

    @Test
    @AllureId("6938")
    @Feature("Заполнение конвертера валют и проверка содержимого при нажатии кнопки Рассчитать")
    public void openPaymentPageAndCheckButtonCalculate() {

        step("Открываем главную страницу и переходим в `Платежи и Переводы`", () -> {
            VTBPages.goToThePaymentPage();
        });
        Allure.step("Переходим на страницу `Обмен валюты`", () ->
                VTBPages.goToTheCurrencyExchangePage());
        Allure.step("Нажимаем на кнопку `Найти отделение`", () ->
                VTBPages.clickButtonSearchOffice());
        step("Проверяем, что страница содержит элемент" + VTBPages.OfficesAndATMs, () ->
                VTBPages.checkResultsAfterClickingOnButtonSearchOffice());
    }

    @Test
    @AllureId("6939")
    @Feature("Скачиваем PDF документ и проверяем количество страниц")
    public void downloadFiles() throws IOException {
        VTBPages.downloadPDFFileAndCheckNumberOfPages();
    }

    @Test
    @AllureId("6933")
    @Feature("Меняем язык на сайте и проверяем содержимое")
    public void changeLanguage() {
        step("Выбираем английский язык", () -> {
            open(VTBPages.VTBMainPage);
            VTBPages.scrollToChangeLanguageAndClickEnglish();
            Allure.step("Проверяем содержимое", () ->
                    VTBPages.checkResultsChangeLanguage());
        });
    }

}
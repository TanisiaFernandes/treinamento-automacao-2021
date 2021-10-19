package tests;

import ElementMapper.CategoryPageElementMapper;
import PageObjects.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import Utils.Browser;
import Utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests {

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    @Story("Realizar o login")
    public void testLogin(){
        //   Browser.getCurrentDriver().findElement(By.className("login")).click();
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        System.out.println("Clicou em Sign In e direcionou para a página de login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        login.fillEmail();
        System.out.println("Preencheu email");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.ClickBtnSubmitLogin();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("index.php?controller=my-account"));
        System.out.println("Validou a URL de minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site");



        //  Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("tamiris@gmail.com");// System.out.println("Preencheu email");
        //  Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("212121");
        //  System.out.println("Preencheu a senha");
        //  Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        //  System.out.println("Clicou em Sign In");
        //  assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("index.php?controller=my-account"));
        //  System.out.println("Validou a URL de minha conta");
        //  assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
//        System.out.println("Validou minha conta no site");
    }
    @Test
    @Story("Acessar Categoria")
    public void testAcessCategoryTShirts(){
        //Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T-SHIRTS
        home.clickCategoryTShirts();

        //validar se ao clicar na categoria T-SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTShirts());
    }

    @Test
    @Story("Acessar página de produto")
    public void testAddProductToProductPage(){
        //Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage PDP = new ProductPage();

        //salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para página do produto
        category.clickProductAddToProductPage();

        //verificar se o produto está na página de produtos corretamente
        assertTrue(PDP.getProductNamePDP().equals(nameProductCategory));
    }

    @Test
    @Story("Adicionar produto ao carrinho")
    public void testAddProductToCartPage(){
        //Acessa página do Produto
        testAddProductToProductPage();

        //Iniciar as Páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //salvar o nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //clicar no botão proceed to chekout da modal
        pdp.clickButtonModalProceedToCheckout();

        //validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
    }


    @Test
    public void testSearch(){
        String quest = "DRESS";
        String questResultQtd = "7";

        //iniciar páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        // fazer a pesquisa
        home.doSearch(quest);

        //validar a pesquisa

        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""),quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }
}

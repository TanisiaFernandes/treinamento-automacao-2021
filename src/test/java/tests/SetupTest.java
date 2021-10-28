package tests;

import PageObjects.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests {

    @Test
    @Story("Criar nova Conta de usuário")

    public void testCreateAnAccount(){
        //iniciar as páginas
        HomePage home = new HomePage();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        home.clickBtnLogin();
        System.out.println("Clicou em SigIn");
        authenticationPage.fillEmail();
        System.out.println("Preencheu campo email");
        authenticationPage.clickSubmitCreate();
        System.out.println("Clicou no btn Create an account");

        createAnAccountPage.fillFirstName();
        System.out.println("Preencheu FirstName");
        assertEquals(createAnAccountPage.getFirstName(), createAnAccountPage.getFirstNameAddress());
        System.out.println("FistName do Cliente e do Endereço são o mesmo.");
        createAnAccountPage.fillLastName();
        System.out.println("Preencheu LastName");
        assertEquals(createAnAccountPage.getLastName(), createAnAccountPage.getLastNameAddress());
        System.out.println("LastName do Cliente e do Endereço são o mesmo.");
        createAnAccountPage.fillPassword();
        System.out.println("Preencheu Password");
        createAnAccountPage.fillAddress();
        System.out.println("Preencheu Address");
        createAnAccountPage.fillCity();
        System.out.println("Preencheu City");
        createAnAccountPage.fillState();
        System.out.println("Preencheu State");
        createAnAccountPage.fillZipPostalCode();
        System.out.println("Preencheu ZipPostalCode");
        createAnAccountPage.fillCountry();
        System.out.println("Preencheu Country");
        createAnAccountPage.fillMobilePhone();
        System.out.println("Preencheu Mobile Phone");
        createAnAccountPage.fillAssign();
        System.out.println("Preencheu Assign");
        createAnAccountPage.clickBtnRegister();
        System.out.println("Clicou no botão Register");

        }

@Test
@Story("Validar fluxo de compra")
public void testValidaCompra(){

        //Iniciar páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();
        SummaryPage summary = new SummaryPage();
        AddressesPage addressesPage = new AddressesPage();
        ShippingPage shippingPage = new ShippingPage();
        PaymentPage paymentPage = new PaymentPage();

        //fazer login no site
        home.clickBtnLogin();
        System.out.println("Clicou em SigIn");
        login.fillEmail();
        System.out.println("Preencheu email");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.ClickBtnSubmitLogin();
        System.out.println("Clicou no btn SigIn");

        //clicar na categoria TSHIRTS
        home.clickCategoryTShirts();
        System.out.println("Clicou na Categoria T-SHIRTS");

        //clicar no produto
        category.clickProductAddToProductPage();
        String nomeDoProdutoPageSummary = pdp.getProductNamePDP();
        System.out.println("Clicou no produto");

        //adicionar ao carrinho
        pdp.clickButtonAddToCart();
        System.out.println("Adicionou o produto ao carrinho");
        assertEquals(pdp.getProductNamePDP(),(nomeDoProdutoPageSummary));
        System.out.println("Verificou se o produto no carrinho é o mesmo que foi selecionado.");
        pdp.clickButtonModalProceedToCheckout();
        System.out.println("Clicou no btn Proceed to checkout e foi para página SUMMARY");
        String qtyProd = summary.getQtyProdSumary();

        //avançar para Addresses
        summary.clickBtnCartProceedToCheckout();
        System.out.println("Clicou no btn Proceed to checkout e foi para página ADDRESSES");

        // avançar para Shipping
        addressesPage.clickBtnAddressesProceedToCheckout();
        System.out.println("Clicou no btn Proceed to checkout e foi para página SHIPPING");

        //clicar em I agree
        shippingPage.clickCheckIAgree();
        System.out.println("Clicou no btn I Aggree");
        String valorShipping = shippingPage.valorFreteShipping.getText();

        //avançar para pagamento
        shippingPage.clickBtnShippingProceedToCheckout();
        System.out.println("Clicou no btn Proceed to checkout e foi para página PAYMENT");

        //verifica se o produto está correto
        assertEquals((nomeDoProdutoPageSummary),paymentPage.nomeDoProdutoPayment.getText());
        System.out.println("o produto está correto.");

        //Verificou se a quantidade está correta
        assertEquals(qtyProd, paymentPage.QtyProdCart.getText());
        System.out.println("A quantidade de produtos está correta");

        //Verificou se o valor está correto
        assertEquals(summary.totalProductSumary.getText(), paymentPage.totalProductPayment.getText());
        System.out.println("O valor do produto está correto");

        //Verificou se o frete está correto
        assertEquals(valorShipping, paymentPage.valorFretePayment.getText());
        System.out.println("O valor do frete está correto");

        //clicar em paybybank
        paymentPage.clickBtnPaybyBank();
        System.out.println("Clicou no btn PayByBank");

        //clicar em confirm my order
        paymentPage.clickBtnIConfirmMyOrder();
        System.out.println("Clicou no btn IConfirmMyOrder");
        }
        }

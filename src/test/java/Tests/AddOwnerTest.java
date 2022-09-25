package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddOwnerTest extends Test_Base {
    Home_Page homePage;
    Owners owner;
    AddOwnerPage addOwner;
    OwnerDetailsPage ownerDetailsPage;
    AddPetDetails addPetDetails;

    Faker faker = new Faker();
    //SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    String firstname=faker.name().firstName();
    String lastname=faker.name().lastName();
    String address=faker.address().streetAddress();
    String city=faker.address().cityName();
    String phoneNumber=String.valueOf(faker.number().digits(10));

    String petName=faker.animal().name();
    String birthday=sdf.format(faker.date().birthday());

    @Test
    public void AddOwnersTest() throws InterruptedException {
        homePage = new Home_Page(getDriver());
        homePage.openOwners();
        owner = new Owners(getDriver());
        owner.addOwnerScreen();
        addOwner = new AddOwnerPage(getDriver());
        addOwner.addOwnerData(firstname, lastname, address, city, phoneNumber);
        addOwner.submitAddOwner();
        ownerDetailsPage = new OwnerDetailsPage(getDriver());
        ownerDetailsPage.clickOnAddPet();
        addPetDetails = new AddPetDetails(getDriver());
        addPetDetails.addPet(petName, birthday);
        addPetDetails.clickOnAddPet();
        Thread.sleep(9000);
        homePage.openFindOwners();
        owner.OpenOwner();
    }


}

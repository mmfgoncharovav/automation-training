package by.bsu.rent.service;

import by.bsu.rent.page.ContactPage;

public class ContactPageChecker {
    public static boolean isAllRentingInfoAvailable(ContactPage page) {
        return page.isEndedRentedVisible()
                && page.isFutureRentedVisible()
                && page.isNotYetRentedVisible()
                && page.isRunningRentedVisible();
    }
}

Feature: Tracking CTB
  As a user, I want to be able tracking without login


  Scenario Outline: Verify create a request test drive without login
    Given Open Request TestDrive popup
    When Select a model
    And Select Dealer and Consultant
    And Select Preffered DateTime
    And Select Customer Information
    And Check Privacy and Confirm
    Then Display Request a Test Drive Completed popup and then close
    And Open Track your Inquiry Booking button with <email> to verify
    And Verify just new item

Examples:
  |model | province | city | distric | dealer | saleconsultant | date | time | title | firstname | lastname | phone | email | comment|
  |CRETA Alpha | DKI Jakarta | Jakarta Selatan | Kebayoran Lama | Hyundai Simprug | Heribert Try Bastanta | 16 | 10.00 | Mr. | Trang | Le | 123456789000 | trang.le@inventis.vn | Trang commemt|

#  @No-param
#  Scenario: Verify tracking page
#    And Click Track your Inquiry Booking button
#    And Input email "trang.le@inventis.vn" and sent it
#    And Input OTP

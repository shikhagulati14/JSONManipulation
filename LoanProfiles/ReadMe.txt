Instructions to Build & Execute:
=================================

Prerequisites:
--------------
Make sure you have installed maven and java on your development machine.


Steps to Build:
----------------
1. From project directory "LoanProfiles" execute "mvn clean install".
2. Copy "loanProfiles-1.0.jar" from target directory to current directory.

Steps Execute Program 1: MarketData
------------------------------------
1. Run following command to execute:
    java -cp loanProfiles-1.0.jar org.fin.loans.main.GenerateTicker "https://test-json-upload-test.s3.ap-south-1.amazonaws.com/marketdata.json"
2. Verify that a file named marketdata.json should be created at the current directory.
3. Structure of marketdata.json should be as follows:
    [
      {
        "ticker": "H",
        "price": 51.31,
        "isin": "US4485791028"
      },
      {
        "ticker": "WNRP",
        "price": 465.0,
        "isin": "US9561524094"
      },
    ....
    ]

Steps to Execute Program 2: Unsecured Loan Alerts
--------------------------------------------------
1. Execute the Program 1 as described above.
2. Make sure loandata.json is copied in current directory, or correct path needs to be provided at time of execution.
3. Run following command to execute:
       java -cp loanProfiles-1.0.jar org.fin.loans.main.GenerateLoanAlerts marketdata.json loandata.json
4. Verify that a file named "unsecuredLoans.json" should be created at the current directory.
5. Structure of unsecuredLoans.json should be as follows:
    [
      {
        "id": "loan23",
        "creditpolicy": "policy2",
        "amount": 67804.0,
        "eligible_collateral": 4895.4488
      },
      {
        "id": "loan29",
        "creditpolicy": "policy1",
        "amount": 147589.0,
        "eligible_collateral": 15590.725600000002
      },
      .....
     ]


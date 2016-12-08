#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <math.h>
#include <algorithm>

#include "savingsCalculator.h"

#define DEPOSIT 1
#define RATE 2
#define TIME 3
#define PERIOD 4
#define NUM_ARGUMENTS 5
#define MONTHLY "yes"
#define MONTHS 12
#define ROUND_FACTOR 10000.0
#define DECIMAL 100
#define INF "\u221E"

using namespace std;

void
fancyPrint( double deposit, double rate, float time ) {
  cout << "Deposit per month: $" << deposit << endl;
  cout << "Annual rate compounded monthly: " << rate << "%" << endl;
  cout << "Time in months: " << time << endl;
  return;
}

int
numberOfDigits( double myNumber ) {
  int digits = 0;
  while( myNumber > 1 ) {
    myNumber /= 10;
    digits++;
  }
  digits += 2;
  return digits;
}

double
compoundedMonthly( double deposit, double rate, float time ) {
  double savings = 0;
  double year = 0;                                    //Initialize year
  double part = modf( time, &year );                  //Initialize part of year
  year *= MONTHS;                                     //Convert year to months
  part *= MONTHS;                                     //Convert fraction of year
  part = round( part );                               //  to nearest whole month
  time = year + part;

  //Show input to user
  fancyPrint( deposit, rate, time );

  //Calculate savings 
  double factor = 1 + (rate / MONTHS);
  //factor = pow( factor, time );
  for( int i = 1; i <= time; i++ ) {
    savings = ( savings + (deposit) ) * factor;
  }
  return savings;
}

int 
main( int argc, char* argv[] ) {
  if( argc < NUM_ARGUMENTS ) {
    cerr << STR_USAGE;
    return -1;
  }

  //Initializing variables
  double mySavings = 0;
  double deposit = stod( argv[DEPOSIT] );             //Convert string to double
  deposit = ceil( deposit );                          //Round to greatest whole
  double rate = stod( argv[RATE] );                   //Convert string to double
  rate /= DECIMAL;
  rate = round( rate * ROUND_FACTOR ) / ROUND_FACTOR; //Round to first decimal
  double time = stod( argv[TIME] );                   //Convert string to double
  string period = argv[PERIOD];
  transform(period.begin(), period.end(), period.begin(), ::tolower);

  //Determine algorithm; Monthly vs Annually
  if( period == MONTHLY ) {
    mySavings = compoundedMonthly( deposit, rate, time );
    int displayDigits = numberOfDigits( mySavings );
    cout << "Your total savings is $"; 
    cout.imbue(locale(""));
    cout << setprecision(displayDigits)<< mySavings << endl;
  }
  else {/*
    mySavings = compoundedAnnually( deposit, rate, time );
    int displayDigits = numberOfDigits( mySavings );
    cout << "Your total savings is $";
    cout.imbue(locale(""));
    cout << setprecision(displayDigits)<< mySavings << endl;*/
  }

  return 0;
}

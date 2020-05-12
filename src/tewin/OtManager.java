/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tewin;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.io.IOException;


/**
 *
 * @author E0051024
 */
public class OtManager extends SearchDB{

    private Integer week;
    private Integer year;
    private double w1ST;
    private double w1TH;
    private double w1DT;
    private double w2ST;
    private double w2TH;
    private double w2DT;
    private double w3ST;
    private double w3TH;
    private double w3DT;
    private double w1pST;
    private double w1pTH;
    private double w1pDT;
    private double w2pST;
    private double w2pTH;
    private double w2pDT;
    private double w3pST;
    private double w3pTH;
    private double w3pDT;

    private String dateWeek1;
    private String dateWeek2;
    private String dateWeek3;

    private int w1DayCount;
    private int w2DayCount;
    private int w3DayCount;

    private Calendar payPeriod1;
    private Calendar payPeriod2;
    private Calendar payPeriod3;
    private Calendar startDate1;
    private Calendar startDate2;
    private Calendar startDate3;
    private Calendar endDate1;
    private Calendar endDate2;
    private Calendar endDate3;

    private String[] OTdataArray;
    /*
     *  OT data Array index list
     *      0-2:    OT date Ranges
     *      3-5:    Pay date Value
     *      6-8:    ST, TH, DT OT for week 1
     *      9-11:   ST, TH, DT OT for week 2
     *      12-14:  ST, TH, DT OT for week 3
     *      15-17:  ST, TH, DT Pay data week 1
     *      18-20:  ST, TH, DT Pay data week 2
     *      21-23:  ST, TH, DT Pay data week 3
     */

    private java.text.DateFormat dateFormat;
    private java.text.DateFormat shortFormat;

    private String user;
    private String manager;

    private Desktop desktop;

    private java.util.Date[] dateArray;
    private Double[] STarray;
    private Double[] THarray;
    private Double[] DTarray;
    private DataConnection dcOtm;

    public OtManager(){
        super(true);
        OTdataArray = new String[24];
        dateFormat = new java.text.SimpleDateFormat("MMMMM dd, yyyy");
        shortFormat = new java.text.SimpleDateFormat("MMMMM dd");
        dcOtm = new DataConnection();
        initVariables();

    }

    public void closeDBconn()
    {
        if (dcOtm.isConnected())
            dcOtm.closeConnection();
    }

    private void initVariables(){
        week = -1;
        year = -1;
        w1ST = 0.0;
        w1TH = 0.0;
        w1DT = 0.0;
        w2ST = 0.0;
        w2TH = 0.0;
        w2DT = 0.0;
        w3ST = 0.0;
        w3TH = 0.0;
        w3DT = 0.0;
        w1pST = 0.0;
        w1pTH = 0.0;
        w1pDT = 0.0;
        w2pST = 0.0;
        w2pTH = 0.0;
        w2pDT = 0.0;
        w3pST = 0.0;
        w3pTH = 0.0;
        w3pDT = 0.0;
        dateWeek1 = "";
        dateWeek2 = "";
        dateWeek3 = "";
        w1DayCount = 0;
        w2DayCount = 0;
        w3DayCount = 0;
        for(int i=0;i<24;i++)
            OTdataArray[i]="";
        user = "";
        manager = "";
    }

    private void clearW1()
    {
        w1ST = 0.0;
        w1TH = 0.0;
        w1DT = 0.0;
        dateWeek1 = "";
        w1DayCount = 0;
        OTdataArray[0]="";
        OTdataArray[3]="";
        OTdataArray[6]="";
        OTdataArray[7]="";
        OTdataArray[8]="";
        OTdataArray[15]="";
        OTdataArray[16]="";
        OTdataArray[17]="";
    }

    private void clearW2()
    {
        w2ST = 0.0;
        w2TH = 0.0;
        w2DT = 0.0;
        dateWeek2 = "";
        w2DayCount = 0;
        OTdataArray[1]="";
        OTdataArray[4]="";
        OTdataArray[9]="";
        OTdataArray[10]="";
        OTdataArray[11]="";
        OTdataArray[18]="";
        OTdataArray[19]="";
        OTdataArray[20]="";

    }

    private void clearW3()
    {
        w3ST = 0.0;
        w3TH = 0.0;
        w3DT = 0.0;
        dateWeek3 = "";
        w3DayCount = 0;
        OTdataArray[2]="";
        OTdataArray[5]="";
        OTdataArray[12]="";
        OTdataArray[13]="";
        OTdataArray[14]="";
        OTdataArray[21]="";
        OTdataArray[22]="";
        OTdataArray[23]="";

    }

    private void moveFwd()
    {
        //set week1 = week2, week2 = week3, get new week 3

        //Week 1 transfer
        payPeriod1 = (Calendar)payPeriod2.clone();
        startDate1 = (Calendar)startDate2.clone();
        endDate1 = (Calendar)endDate2.clone();
        w1DayCount = w2DayCount;
        w1ST = w2ST;
        w1TH = w2TH;
        w1DT = w2DT;
        OTdataArray[0] = OTdataArray[1];
        OTdataArray[3] = OTdataArray[4];
        OTdataArray[6] = OTdataArray[9];
        OTdataArray[7] = OTdataArray[10];
        OTdataArray[8] = OTdataArray[11];
        OTdataArray[15] = OTdataArray[18];
        OTdataArray[16] = OTdataArray[19];
        OTdataArray[17] = OTdataArray[20];


        //week 2 transfer
        payPeriod2 = (Calendar)payPeriod3.clone();
        startDate2 = (Calendar)startDate3.clone();
        endDate2 = (Calendar)endDate3.clone();
        w2DayCount = w3DayCount;
        w2ST = w3ST;
        w2TH = w3TH;
        w2DT = w3DT;
        OTdataArray[1] = OTdataArray[2];
        OTdataArray[4] = OTdataArray[5];
        OTdataArray[9] = OTdataArray[12];
        OTdataArray[10] = OTdataArray[13];
        OTdataArray[11] = OTdataArray[14];
        OTdataArray[18] = OTdataArray[21];
        OTdataArray[19] = OTdataArray[22];
        OTdataArray[20] = OTdataArray[23];

        //Get final week
        getW3();
    }

    public String[] refreshOTM(){
        getW1();
        getW2();
        getW3();
        return OTdataArray;

    }

    private void moveBack()
    {
        //set week3 = week2, week2 = week1, get new week 1

        //Week 1 transfer
        payPeriod3 = (Calendar)payPeriod2.clone();
        startDate3 = (Calendar)startDate2.clone();
        endDate3 = (Calendar)endDate2.clone();
        w3DayCount = w2DayCount;
        w3ST = w2ST;
        w3TH = w2TH;
        w3DT = w2DT;
        OTdataArray[2] = OTdataArray[1];
        OTdataArray[5] = OTdataArray[4];
        OTdataArray[12] = OTdataArray[9];
        OTdataArray[13] = OTdataArray[10];
        OTdataArray[14] = OTdataArray[11];
        OTdataArray[21] = OTdataArray[18];
        OTdataArray[22] = OTdataArray[19];
        OTdataArray[23] = OTdataArray[20];

        //week 2 transfer
        payPeriod2 = (Calendar)payPeriod1.clone();
        startDate2 = (Calendar)startDate1.clone();
        endDate2 = (Calendar)endDate1.clone();
        w2DayCount = w1DayCount;
        w2ST = w1ST;
        w2TH = w1TH;
        w2DT = w1DT;
        OTdataArray[1] = OTdataArray[0];
        OTdataArray[4] = OTdataArray[3];
        OTdataArray[9] = OTdataArray[6];
        OTdataArray[10] = OTdataArray[7];
        OTdataArray[11] = OTdataArray[8];
        OTdataArray[18] = OTdataArray[15];
        OTdataArray[19] = OTdataArray[16];
        OTdataArray[20] = OTdataArray[17];

        //Get final week
        getW1();

    }

    private String formatOTresults()
    {
        String otResultString="";
        int counter = 0;
        String rsLine;
        if(resultCount>0)
        {
            while(counter<resultDate.size())
            {
                //add results to result string

                //Add Date
                rsLine=shortFormat.format((java.util.Date)this.resultDate.get(counter)) + " " +
                        (String)this.resultJobNum.get(counter) + " " +
                        (String)this.resultTaskID.get(counter) + " " +
                        (String)this.resultLaborType.get(counter) + " " +
                        formatter.format((Double)this.resultHours.get(counter)) + " " +
                        (String)this.resultComment.get(counter) + "\n";

                counter++;
                otResultString+=rsLine;
            }
        }

        return otResultString;
    }

    public void shortReport(int weekNum)
    {
        String otRange = "Missing OT for dates ";
        String message = "My records indicate I'm missing OT on Pay Date ";
        

        switch(weekNum){
            case 1:
                //otSearch(startDate1.getTime(),endDate1.getTime());
                //dc.closeConnection();
                otRange+=dateWeek1;
                message= message + dateFormat.format(payPeriod1.getTime()).toString() + "\n\n";
                message+= "Recorded Straight Time OT = " + Double.toString(w1ST) + "\n";
                message+= "Recorded Time and Half OT = " + Double.toString(w1TH) + "\n";
                message+= "Recorded Double Time   OT = " + Double.toString(w1DT) + "\n\n";
                message+= "Pay Straight Time OT = " + Double.toString(w1pST) + "\n";
                message+= "Pay Time and Half OT = " + Double.toString(w1pTH) + "\n";
                message+= "Pay Double Time   OT = " + Double.toString(w1pDT) + "\n\n";
                message+= "          ----OT RECORDED BY DATE----\n";
                for(int i=0;i<w1DayCount;i++)
                {
                    message+= shortFormat.format(dateArray[i].getTime()).toString() + "\t ST = " +
                            Double.toString(STarray[i]) + "\t TH = " + Double.toString(THarray[i]) +
                            "\t DT = " + Double.toString(DTarray[i]) + "\n";
                }

                break;
            case 2:
                otRange+=dateWeek2;
                message= message + dateFormat.format(payPeriod2.getTime()).toString() + "\n\n";
                message+= "Recorded Straight Time OT = " + Double.toString(w2ST) + "\n";
                message+= "Recorded Time and Half OT = " + Double.toString(w2TH) + "\n";
                message+= "Recorded Double Time   OT = " + Double.toString(w2DT) + "\n\n";
                message+= "Pay Straight Time OT = " + Double.toString(w2pST) + "\n";
                message+= "Pay Time and Half OT = " + Double.toString(w2pTH) + "\n";
                message+= "Pay Double Time   OT = " + Double.toString(w2pDT) + "\n\n";
                message+= "          ----OT RECORDED BY DATE----\n";
                for(int i=w1DayCount;i<w2DayCount+w1DayCount;i++)
                {
                    message+= shortFormat.format(dateArray[i].getTime()).toString() + "\t ST = " +
                            Double.toString(STarray[i]) + "\t TH = " + Double.toString(THarray[i]) +
                            "\t DT = " + Double.toString(DTarray[i]) + "\n";
                }
                break;
            case 3:
                otRange+=dateWeek3;
                message= message + dateFormat.format(payPeriod3.getTime()).toString() + "\n\n";
                message+= "Recorded Straight Time OT = " + Double.toString(w3ST) + "\n";
                message+= "Recorded Time and Half OT = " + Double.toString(w3TH) + "\n";
                message+= "Recorded Double Time   OT = " + Double.toString(w3DT) + "\n\n";
                message+= "Pay Straight Time OT = " + Double.toString(w3pST) + "\n";
                message+= "Pay Time and Half OT = " + Double.toString(w3pTH) + "\n";
                message+= "Pay Double Time   OT = " + Double.toString(w3pDT) + "\n\n";
                message+= "               ----OT RECORDED BY DATE----\n";
                for(int i=w1DayCount+w2DayCount;i<w1DayCount+w2DayCount+w3DayCount;i++)
                {
                    message+= shortFormat.format(dateArray[i].getTime()).toString() + "\t ST = " +
                            Double.toString(STarray[i]) + "\t TH = " + Double.toString(THarray[i]) +
                            "\t DT = " + Double.toString(DTarray[i]) + "\n";
                }
                break;
            default:
                break;
        }

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
            //String mailTo = "duke@sun.com?SUBJECT=Happy New Year!&BODY=Happy New Year, Duke!";
            String mailTo = manager + "&CC=" + user + "?SUBJECT=" + otRange + "&BODY=" + message;
            URI uriMailTo = null;
            try {
                if (mailTo.length() > 0) {
                    uriMailTo = new URI("mailto", mailTo, null);
                    desktop.mail(uriMailTo);
                } else {
                    desktop.mail();
                }
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
                System.out.println(ioe);
            }
            catch(URISyntaxException use) {
                use.printStackTrace();
                System.out.println(use);
            }
        }

    }
    public String[] getValues(int wks, int yrs, String user, String manager){
        this.user = user;
        this.manager = manager;
        /*
        if(week<0||year<0)
        {
            week=wks;
            year=yrs;
            getW1();
            getW2();
            getW3();
        }else if(yrs==year&&week == (wks-2))
        {
            //moved forward one pay period shift dates
            moveFwd();
        }else if(yrs==year&&week == (wks+2))
        {
            //moved back one pay period shift dates
            moveBack();
        }


         *
         */
        //Date formatter for range views
        week = wks;
        year = yrs;
        clearW1();
        clearW2();
        clearW3();

        //Set Date Ranges based on current year/week sent
        startDate1 = Calendar.getInstance();
        startDate2 = (Calendar)startDate1.clone();
        startDate3 = (Calendar)startDate1.clone();
        endDate1 = (Calendar)startDate1.clone();
        endDate2 = (Calendar)startDate1.clone();
        endDate3 = (Calendar)startDate1.clone();

        startDate1.set(Calendar.YEAR, year);
        startDate1.set(Calendar.WEEK_OF_YEAR, week);

        //Decide if current day of month is end or begining of month
        if(startDate1.get(Calendar.DAY_OF_MONTH)>=15)
        {
            startDate1.set(Calendar.DAY_OF_MONTH, 16);
            dateWeek1 = shortFormat.format(startDate1.getTime()) + " - ";
            payPeriod1 = (Calendar)startDate1.clone();
            payPeriod1.add(Calendar.DAY_OF_YEAR,30);
            payPeriod1.set(Calendar.DAY_OF_MONTH,1);
            payPeriod1.add(Calendar.DAY_OF_YEAR, -1);
            dateWeek1 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate1 = (Calendar)payPeriod1.clone();
            payPeriod1.add(Calendar.DAY_OF_YEAR, 1);
            dateWeek2 = shortFormat.format(payPeriod1.getTime()) + " - ";
            startDate2 = (Calendar)payPeriod1.clone();
            payPeriod1.set(Calendar.DAY_OF_MONTH,15);
            payPeriod2 = (Calendar)payPeriod1.clone();

            payPeriod2.set(Calendar.DAY_OF_MONTH,15);
            dateWeek2 += shortFormat.format(payPeriod2.getTime()) + ", " + Integer.toString(payPeriod2.get(Calendar.YEAR));
            endDate2 = (Calendar)payPeriod2.clone();
            payPeriod3 = (Calendar)payPeriod2.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR, 1);
            dateWeek3 = shortFormat.format(payPeriod3.getTime()) + " - ";
            startDate3 = (Calendar)payPeriod3.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR,30);
            payPeriod2.set(Calendar.DAY_OF_MONTH,1);
            payPeriod2.add(Calendar.DAY_OF_YEAR, -1);
            payPeriod3 = (Calendar)payPeriod1.clone();
            payPeriod3.add(Calendar.DAY_OF_MONTH, 1);

            payPeriod3.add(Calendar.DAY_OF_YEAR,30);
            payPeriod3.set(Calendar.DAY_OF_MONTH,1);
            payPeriod3.add(Calendar.DAY_OF_YEAR, -1);
            dateWeek3 += shortFormat.format(payPeriod3.getTime()) + ", " + Integer.toString(payPeriod3.get(Calendar.YEAR));
            endDate3 = (Calendar)payPeriod3.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR,1);
            payPeriod3.set(Calendar.DAY_OF_MONTH, 15);

        }else
        {
            startDate1.set(Calendar.DAY_OF_MONTH, 1);
            dateWeek1 = shortFormat.format(startDate1.getTime()) + " - ";
            payPeriod1 = (Calendar)startDate1.clone();
            payPeriod1.set(Calendar.DAY_OF_MONTH,15);
            dateWeek1 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate1 = (Calendar)payPeriod1.clone();
            payPeriod2 = (Calendar)payPeriod1.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR,1);
            dateWeek2 = shortFormat.format(payPeriod2.getTime()) + " - ";
            startDate2 = (Calendar)payPeriod2.clone();
            payPeriod1.add(Calendar.DAY_OF_YEAR, 30);
            payPeriod1.set(Calendar.DAY_OF_MONTH, 1);
            payPeriod1.add(Calendar.DAY_OF_YEAR, -1);
            dateWeek2 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate2 = (Calendar)payPeriod1.clone();
            payPeriod2 = (Calendar)payPeriod1.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR, 1);
            dateWeek3 = shortFormat.format(payPeriod2.getTime()) + " - ";
            startDate3 = (Calendar)payPeriod2.clone();
            payPeriod2.set(Calendar.DAY_OF_MONTH, 15);
            payPeriod3 = (Calendar)payPeriod2.clone();
            dateWeek3 += shortFormat.format(payPeriod3.getTime()) + ", " + Integer.toString(payPeriod3.get(Calendar.YEAR));
            endDate3 = (Calendar)payPeriod3.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR,30);
            payPeriod3.set(Calendar.DAY_OF_MONTH, 1);
            payPeriod3.add(Calendar.DAY_OF_YEAR, -1);


        }

        //Update GUI with date ranges and pay dates
        OTdataArray[0]= dateWeek1;
        OTdataArray[1]= dateWeek2;
        OTdataArray[2]= dateWeek3;
        OTdataArray[3]= dateFormat.format(payPeriod1.getTime());
        OTdataArray[4]= dateFormat.format(payPeriod2.getTime());
        OTdataArray[5]= dateFormat.format(payPeriod3.getTime());



        //Populate date array
        Calendar working = (Calendar)startDate1.clone();
        int totalDays=0;

        //get total day counts
        w1DayCount = endDate1.get(Calendar.DAY_OF_YEAR) - startDate1.get(Calendar.DAY_OF_YEAR)+1;
        w2DayCount = endDate2.get(Calendar.DAY_OF_YEAR) - startDate2.get(Calendar.DAY_OF_YEAR)+1;
        w3DayCount = endDate3.get(Calendar.DAY_OF_YEAR) - startDate3.get(Calendar.DAY_OF_YEAR)+1;
        totalDays = w1DayCount+w2DayCount+w3DayCount;
        //Initialize arrays
        dateArray = new java.util.Date[totalDays];
        STarray = new Double[totalDays];
        THarray = new Double[totalDays];
        DTarray = new Double[totalDays];



        for(int i=0;i<totalDays;i++)
        {
            dateArray[i] = working.getTime();
            STarray[i] = 0.0;
            THarray[i] = 0.0;
            DTarray[i] = 0.0;
            working.add(Calendar.DAY_OF_YEAR, 1);
        }

        //set starting day key
        int startWeek = startDate1.get(Calendar.WEEK_OF_YEAR);
        int startYear = startDate1.get(Calendar.YEAR);
        int endWeek = payPeriod2.get(Calendar.WEEK_OF_YEAR);
        int endYear = payPeriod2.get(Calendar.YEAR);

        String query= "SELECT * FROM TimeData WHERE ( ";

        int yearCount = endYear-startYear;
        //IF Search is within the same Year
        if(yearCount==0)
        {
            query += "((Year =  " + Integer.toString(startYear) + ") AND ((" +
                    "Week_Number >=  " + Integer.toString(startWeek)  + ") AND " +
                    "Week_Number <=  " + Integer.toString(endWeek) + "))";
        }else if(yearCount>=1){
            //Add partial first year
            query += "((Year =  " + Integer.toString(startYear) + " AND " +
                "Week_Number >=  " + Integer.toString(startWeek)  + ") OR ";

            //Add interm years
            for(int i=1;i<yearCount;i++){
                query+= "(Year = " + Integer.toString(startYear+i) + ") OR ";
            }

            //add final partial year
            query +="(Year =  " + Integer.toString(endYear) + " AND " +
               "Week_Number <=  " + Integer.toString(endWeek) + " )) ";
        }

        query+= " )";
        dcOtm.connect();
        java.sql.ResultSet rst = dcOtm.dbQuery(query);

        try{
            int yr,wk;
            Calendar search = Calendar.getInstance();
            double tempHrs;
            String lbrType;

            while(rst.next())
            {
                //Set line parameters for line in result set
                yr = rst.getInt(2);
                search.set(Calendar.YEAR, yr);
                wk = rst.getInt(3);
                search.set(Calendar.WEEK_OF_YEAR, wk);
                search.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                lbrType = rst.getString(6);

                for(int dayCtr=7;dayCtr<=19;dayCtr+=2)
                {
                    tempHrs = rst.getDouble(dayCtr);
                    for(int i=0;i<totalDays;i++)
                    {
                        if(dateFormat.format(search.getTime()).equals(dateFormat.format(dateArray[i])))
                        {
                            if(lbrType.equalsIgnoreCase("EESD Labor"))
                            {
                                if(tempHrs>8)
                                    STarray[i]+=(tempHrs-8);
                            }else if(lbrType.equalsIgnoreCase("EESD Time and Half"))
                            {
                                THarray[i]+=tempHrs;
                            }else if(lbrType.equalsIgnoreCase("EESD Double Time"))
                            {
                                DTarray[i]+=tempHrs;
                            }else
                                continue;
                        }
                    }
                    search.add(Calendar.DAY_OF_YEAR, 1);
                }
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }


        //get pay data
        try{
            //Pay Period 1
            int payTag = payPeriod1.get(Calendar.DAY_OF_MONTH);
            query = "SELECT * FROM PayHistory WHERE ( PayYear = " +
                        Integer.toString(payPeriod1.get(Calendar.YEAR)) + " AND " +
                        "PayMonth = " + Integer.toString(payPeriod1.get(Calendar.MONTH));
            if(payTag==15)
            {
                query+=" AND PayDay <= 15)";
            }else
            {
                query+=" AND PayDay >= 16)";
            }

            rst = dcOtm.dbQuery(query);
            if(rst.next())
            {
                w1pST = rst.getDouble("ST");
                w1pTH = rst.getDouble("TH");
                w1pDT = rst.getDouble("DT");
                OTdataArray[15] = Double.toString(w1pST);
                OTdataArray[16] = Double.toString(w1pTH);
                OTdataArray[17] = Double.toString(w1pDT);

            }else
            {
                w1pST = 0.0;
                w1pTH = 0.0;
                w1pDT = 0.0;
                OTdataArray[15] = "0.0";
                OTdataArray[16] = "0.0";
                OTdataArray[17] = "0.0";
            }


            //Pay Period 2
            payTag = payPeriod2.get(Calendar.DAY_OF_MONTH);
            query = "SELECT * FROM PayHistory WHERE ( PayYear = " +
                        Integer.toString(payPeriod2.get(Calendar.YEAR)) + " AND " +
                        "PayMonth = " + Integer.toString(payPeriod2.get(Calendar.MONTH));
            if(payTag==15)
            {
                query+=" AND PayDay <= 15)";
            }else
            {
                query+=" AND PayDay >= 16)";
            }

            rst = dcOtm.dbQuery(query);
            if(rst.next())
            {
                w2pST = rst.getDouble("ST");
                w2pTH = rst.getDouble("TH");
                w2pDT = rst.getDouble("DT");
                OTdataArray[18] = Double.toString(w2pST);
                OTdataArray[19] = Double.toString(w2pTH);
                OTdataArray[20] = Double.toString(w2pDT);
            }else
            {
                w2pST = 0.0;
                w2pTH = 0.0;
                w2pDT = 0.0;
                OTdataArray[18] = "0.0";
                OTdataArray[19] = "0.0";
                OTdataArray[20] = "0.0";
            }


            //Pay Period 3
            payTag = payPeriod3.get(Calendar.DAY_OF_MONTH);
            query = "SELECT * FROM PayHistory WHERE ( PayYear = " +
                        Integer.toString(payPeriod3.get(Calendar.YEAR)) + " AND " +
                        "PayMonth = " + Integer.toString(payPeriod3.get(Calendar.MONTH));
            if(payTag==15)
            {
                query+=" AND PayDay <= 15)";
            }else
            {
                query+=" AND PayDay >= 16)";
            }

            rst = dcOtm.dbQuery(query);
            if(rst.next())
            {
                w3pST = rst.getDouble("ST");
                w3pTH = rst.getDouble("TH");
                w3pDT = rst.getDouble("DT");
                OTdataArray[21] = Double.toString(w3pST);
                OTdataArray[22] = Double.toString(w3pTH);
                OTdataArray[23] = Double.toString(w3pDT);
            }else
            {
                w3pST = 0.0;
                w3pTH = 0.0;
                w3pDT = 0.0;
                OTdataArray[21] = "0.0";
                OTdataArray[22] = "0.0";
                OTdataArray[23] = "0.0";
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }

        dcOtm.closeConnection();

        //group date array data into weeks
      
        for(int i=0;i<totalDays;i++)
        {
            if(i<w1DayCount)
            {
                w1ST+=STarray[i];
                w1TH+=THarray[i];
                w1DT+=DTarray[i];
            }else
            if(i>=w1DayCount && i<(w1DayCount+w2DayCount))
            {
                w2ST+=STarray[i];
                w2TH+=THarray[i];
                w2DT+=DTarray[i];
            }else
            {
                w3ST+=STarray[i];
                w3TH+=THarray[i];
                w3DT+=DTarray[i];
            }
        }

        OTdataArray[6] = Double.toString(w1ST);
        OTdataArray[7] = Double.toString(w1TH);
        OTdataArray[8] = Double.toString(w1DT);
        OTdataArray[9] = Double.toString(w2ST);
        OTdataArray[10] = Double.toString(w2TH);
        OTdataArray[11] = Double.toString(w2DT);
        OTdataArray[12] = Double.toString(w3ST);
        OTdataArray[13] = Double.toString(w3TH);
        OTdataArray[14] = Double.toString(w3DT);



        return OTdataArray;

    }

    private void getW1()
    {
        startDate1 = Calendar.getInstance();
        startDate1.set(Calendar.YEAR, year);
        startDate1.set(Calendar.WEEK_OF_YEAR, week);

        if(startDate1.get(Calendar.DAY_OF_MONTH)>=15)
        {
            startDate1.set(Calendar.DAY_OF_MONTH, 16);
            dateWeek1 = shortFormat.format(startDate1.getTime()) + " - ";
            payPeriod1 = (Calendar)startDate1.clone();
            payPeriod1.add(Calendar.DAY_OF_YEAR,30);
            payPeriod1.set(Calendar.DAY_OF_MONTH,1);
            payPeriod1.add(Calendar.DAY_OF_YEAR, -1);
            dateWeek1 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate1 = (Calendar)payPeriod1.clone();
            payPeriod1.add(Calendar.DAY_OF_YEAR, 1);
            payPeriod1.set(Calendar.DAY_OF_MONTH,15);
        }else
        {
            startDate1.set(Calendar.DAY_OF_MONTH, 1);
            dateWeek1 = shortFormat.format(startDate1.getTime()) + " - ";
            payPeriod1 = (Calendar)startDate1.clone();
            payPeriod1.set(Calendar.DAY_OF_MONTH,15);
            dateWeek1 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate1 = (Calendar)payPeriod1.clone();

            payPeriod1.add(Calendar.DAY_OF_YEAR, 30);
            payPeriod1.set(Calendar.DAY_OF_MONTH, 1);
            payPeriod1.add(Calendar.DAY_OF_YEAR, -1);
        }

        OTdataArray[0]= dateWeek1;
        OTdataArray[3]= dateFormat.format(payPeriod1.getTime());



    }

    private void getW2()
    {
        if(startDate1.get(Calendar.DAY_OF_MONTH)>=15)
        {
            dateWeek2 = shortFormat.format(payPeriod1.getTime()) + " - ";
            startDate2 = (Calendar)payPeriod1.clone();
            payPeriod2 = (Calendar)payPeriod1.clone();
            payPeriod2.set(Calendar.DAY_OF_MONTH,15);
            dateWeek2 += shortFormat.format(payPeriod2.getTime()) + ", " + Integer.toString(payPeriod2.get(Calendar.YEAR));
            endDate2 = (Calendar)payPeriod2.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR,30);
            payPeriod2.set(Calendar.DAY_OF_MONTH,1);
            payPeriod2.add(Calendar.DAY_OF_YEAR, -1);

        }else
        {

            payPeriod2 = (Calendar)payPeriod1.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR,1);
            dateWeek2 = shortFormat.format(payPeriod2.getTime()) + " - ";
            startDate2 = (Calendar)payPeriod2.clone();
            dateWeek2 += shortFormat.format(payPeriod1.getTime()) + ", " + Integer.toString(payPeriod1.get(Calendar.YEAR));
            endDate2 = (Calendar)payPeriod1.clone();
            payPeriod2 = (Calendar)payPeriod1.clone();
            payPeriod2.add(Calendar.DAY_OF_YEAR, 1);
            payPeriod2.set(Calendar.DAY_OF_MONTH, 15);
        }

        OTdataArray[1]= dateWeek2;
        OTdataArray[4]= dateFormat.format(payPeriod2.getTime());

    }

    private void getW3()
    {
        if(startDate1.get(Calendar.DAY_OF_MONTH)>=15)
        {
            //INCOMPLETE!!!!!!!!!!!!!!!
            payPeriod3 = (Calendar)payPeriod2.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR, 1);
            dateWeek3 = shortFormat.format(payPeriod3.getTime()) + " - ";
            startDate3 = (Calendar)payPeriod3.clone();
            payPeriod3 = (Calendar)payPeriod1.clone();
            payPeriod3.add(Calendar.DAY_OF_MONTH, 1);
            payPeriod3.add(Calendar.DAY_OF_YEAR,30);
            payPeriod3.set(Calendar.DAY_OF_MONTH,1);
            payPeriod3.add(Calendar.DAY_OF_YEAR, -1);
            dateWeek3 += shortFormat.format(payPeriod3.getTime()) + ", " + Integer.toString(payPeriod3.get(Calendar.YEAR));
            endDate3 = (Calendar)payPeriod3.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR,1);
            payPeriod3.set(Calendar.DAY_OF_MONTH, 15);

        }else
        {
            //INCOMPLETE
            dateWeek3 = shortFormat.format(payPeriod2.getTime()) + " - ";
            startDate3 = (Calendar)payPeriod2.clone();
            payPeriod3 = (Calendar)payPeriod2.clone();
            dateWeek3 += shortFormat.format(payPeriod3.getTime()) + ", " + Integer.toString(payPeriod3.get(Calendar.YEAR));
            endDate3 = (Calendar)payPeriod3.clone();
            payPeriod3.add(Calendar.DAY_OF_YEAR,30);
            payPeriod3.set(Calendar.DAY_OF_MONTH, 1);
            payPeriod3.add(Calendar.DAY_OF_YEAR, -1);


        }

        OTdataArray[2]= dateWeek3;
        OTdataArray[5]= dateFormat.format(payPeriod3.getTime());

    }



}

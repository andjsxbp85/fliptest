package Utils;

import net.thucydides.core.pages.PageObject;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class funct extends PageObject {
    public long getCurrrentTimeMs(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static String currentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String currentTime(String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    //============ Date Converter:  Milis <> Time ============
    //For input format must be in YYYY-MM-DD HH:MM:SS
    public long convertTimeToMs(String timeNow){
        return Timestamp.valueOf(timeNow).getTime();
    }

    public String convertMsToTime(long timeStampMs){
        Date date = new Date(timeStampMs);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = formatter.format(date);
        return dateFormatted;
    }

    public String convertMsToTime(long timeStampMs, String format){
        Date date = new Date(timeStampMs);
        DateFormat formatter = new SimpleDateFormat(format);
        String dateFormatted = formatter.format(date);
        return dateFormatted;
    }

    // format yyyy/MM/dd HH:mm:ss to yyyy-MM-dd HH:mm:ss
    public String dateFormatter(String dateNow){
        return dateNow.replace("/","-");
    }

    // =======================  Time Calculation =======================
    //Param  falseMinTruePlus == false >> result = acuan - faktor
    //Param falseMinTruePlus == true >> result = acuan + faktor
    public long timeCalculation(long acuan, long faktor, boolean falseMinTruePlus){
        if(falseMinTruePlus) return acuan += faktor;
        else return acuan-=faktor;
    }

    //Date format must be yyyy-MM-dd HH:mm:ss
    public String timeCalculation(String dateFormat, long acuan, long faktor, boolean falseMinTruePlus){
        if(falseMinTruePlus) acuan += faktor;
        else acuan-=faktor;
        Date date = new Date(acuan);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    //Date format must be yyyy-MM-dd HH:mm:ss
    public String timeCalculation(String dateFormat, String acuan, String faktor, boolean falseMinTruePlus){
        long acuanMs = convertTimeToMs(acuan);
        long faktorMs = convertTimeToMs(faktor);
        if(falseMinTruePlus) acuanMs += faktorMs;
        else acuanMs-=faktorMs;
        Date date = new Date(acuanMs);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    //Randomizer >> kerapatan konstanta 999 >> kalau bisa dibuat parameter buat dynamic kerapatan konstanta
    public int randomizerInt(int min, int max){
        //RUMUS ASLI = min+((max-min)*constant/1000) >> krn int selalu rounding ke bawah, maka perlu dihitung dlm double dulu biar bisa rounding dgn benar
        int constant = Integer.parseInt(Long.toString(getCurrrentTimeMs()).substring(10)); //char ke 10+1 = 11
        double cons =  (double) constant/ 999; //contoh milis (1598885879769) >> substring char ke 10+1 = 11 >> didapat 769 >> maksimum 999
        //df.setRoundingMode(RoundingMode.UP);
        //df.setRoundingMode(RoundingMode.DOWN);
        //df.setRoundingMode(RoundingMode.HALF_EVEN); //default value HALF_EVEN // gk perlu diketik lagi karena pengen default rounding
        cons = min+(max-min)*cons;
        DecimalFormat df = new DecimalFormat("0"); //0 berarti gk ada koma (bilangan bulat) >> 0.0 berarti 1 desimal di blkng koma > 0.00 berarti 2 desimal di blkng koma >> dst...
        cons = Double.parseDouble(df.format(cons));
        constant = (int) cons;
        return constant;
    }

    public String lastDateInAMonth(String month){
        String date="";
        switch (month){
            case "01": date = "31"; break;
            case "1": date = "31"; break;
            case "02": date = "29"; break;
            case "2": date = "29"; break;
            case "03": date = "31"; break;
            case "3": date = "31"; break;
            case "04": date = "30"; break;
            case "4": date = "30"; break;
            case "05": date = "31"; break;
            case "5": date = "31"; break;
            case "06": date = "30"; break;
            case "6": date = "30"; break;
            case "07": date = "31"; break;
            case "7": date = "31"; break;
            case "08": date = "31"; break;
            case "8": date = "31"; break;
            case "09": date = "30"; break;
            case "9": date = "30"; break;
            case "10": date = "31"; break;
            case "11": date = "30"; break;
            case "12": date = "31"; break;
        }
        return date;
    }

    //======== Read and Write File TXT ==========
    //Write label content
    public void writeFileDataTxt(String nameTxtFile, String label, String content){
        //=======Desired path
        String directory = System.getProperty("user.dir")+"/src";
        String fileName = nameTxtFile;
        String absolutePath = directory + File.separator + fileName;
        //=======Read content first, avoid replacing old data
        String dataNow = readFileDataTxt(nameTxtFile);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            String fileContent = dataNow+"["+label+"]"+content;
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Write");}
    }

    public void writeFileDataTxt(String nameTxtFile, String label, List<String> content){
        //=======Desired path
        String directory = System.getProperty("user.dir")+"/src";
        String fileName = nameTxtFile;
        String absolutePath = directory + File.separator + fileName;
        //=======Read content first, avoid replacing old data
        String dataNow = readFileDataTxt(nameTxtFile);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            String fileContent = dataNow+"["+label+"]"+content;
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Write");}
    }

    public void OVERwriteFileDataTxt(String nameTxtFile, String content){
        //=======Desired path
        String directory = System.getProperty("user.dir")+"/src";
        String fileName = nameTxtFile;
        String absolutePath = directory + File.separator + fileName;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            String fileContent = content;
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Write");}
    }

//    public List<String> OVERwriteFileDataTxt(String nameTxtFile, List<String> content){
//        //=======Desired path
//        List<String> data = new ArrayList<String>();
//        String datanya = "";
//        String directory = System.getProperty("user.dir")+"/src";
//        String fileName = nameTxtFile;
//        String absolutePath = directory + File.separator + fileName;
//        for(String konten:content){
//
//        }
//        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
//            String fileContent = datanya;
//            bufferedWriter.write(fileContent);
//        } catch (IOException e) { System.out.println("Error Write");}
//        return data;
//    }


    //Read all label
    public String readFileDataTxt(String nameTxtFile){
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        String readerText = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                readerText = readerText+line+"\n";
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        return readerText;
    }

    //Read every row of data to list data
    public List<String> readFileTxtToList(String nameTxtFile){
        List<String> dataFile = new ArrayList<>();
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                dataFile.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File "+nameTxtFile+" NOT FOUND!");
        } catch (IOException e) {
            System.out.println("Label Data Not Found");
        }
        return dataFile;
    }

    //Read desired label
    public List<String> readFileTxtToList(String nameTxtFile, String label){
        List<String> dataFile = new ArrayList<>();
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                if(line.contains("["+label+"]"))dataFile.add(line.substring(line.indexOf(label)+label.length()+2));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File "+nameTxtFile+" NOT FOUND!");
        } catch (IOException e) {
            System.out.println("Label Data Not Found");
        }
        return dataFile;
    }

    public List<String> readFileTxtToList(String nameTxtFile, String mainLabel, String detailLabel){
        List<String> dataFile = new ArrayList<>();
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                if(line.contains("["+mainLabel+"]") && line.contains("["+detailLabel+"]"))dataFile.add(line.substring(line.indexOf(detailLabel)+detailLabel.length()+2));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File "+nameTxtFile+" NOT FOUND!");
        } catch (IOException e) {
            System.out.println("Label Data Not Found");
        }
        return dataFile;
    }

    //=========Editing and Saving Coloumn File CSV
    public String editingColoumnRowData(String nameTxtFile, int baris, int kolom, String editedValue){
        //Editing File
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        String readerText = ""; String barisAwal = "", barisAkhir = "", editWord = ""; int i=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                if(i<baris) barisAwal = barisAwal+line+"\n";
                else if(i==baris) editWord = line;
                else if(i>baris) barisAkhir = barisAkhir+line+"\n";
                line = bufferedReader.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        List<Integer> lokasi = new ArrayList<Integer>(); String awal = "", akhir = "";
        for(i=0;i<editWord.length();i++){
            if(editWord.charAt(i)==',')lokasi.add(i);
        }
        if(kolom==0){ //kolom pertama
            akhir = editWord.substring(lokasi.get(kolom));
        }else if(kolom==lokasi.size()){ //kolom akhir
            awal = editWord.substring(0,lokasi.get(kolom-1)+1); //kolom -1 karena 2 kata = 1 koma, 3 kata = 2 koma, 4 kata = 3 koma, dst
        }else{ //DI tengah
            awal = editWord.substring(0,lokasi.get(kolom-1)+1);
            akhir = editWord.substring(lokasi.get(kolom));
        }
        editedValue = awal+editedValue+akhir;
        String fileContent = "";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            fileContent = barisAwal+editedValue+"\n"+barisAkhir;
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Write");}
        System.out.println("=============\n"+fileContent);
        return fileContent;
    }

    public String readRowCol(String nameTxtFile, int baris, int kolom){
        //Editing File
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        String readerText = ""; int i=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                if(i==baris){readerText = line; break;}
                line = bufferedReader.readLine(); i++;
            }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        if(readerText.equals("")){ System.out.println("Baris yang Anda Cari Tidak Ada"); return null;}
        List<Integer> lokasi = new ArrayList<Integer>(); int length = readerText.length();
        for(i=0;i<length;i++){
            if(readerText.charAt(i)==',')lokasi.add(i);
        }
        String fileContent = "";
        try {
            if (kolom == 0) fileContent = readerText.substring(0, lokasi.get(0));
            else if (kolom == lokasi.size()) fileContent = readerText.substring(lokasi.get(lokasi.size() - 1) + 1);
            else fileContent = readerText.substring(lokasi.get(kolom - 1) + 1, lokasi.get(kolom));
        }catch (IndexOutOfBoundsException e){ System.out.println("Kolom yang Anda Cari Tidak Ada"); return null;}
        System.out.println("=============\n"+fileContent);
        return fileContent;
    }

    public void changeAllColoumnData(String nameTxtFile, int kolom, String desiredValue){
        //Editing File
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        String fileContent = ""; int i=0, j=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                List<Integer> lokasi = new ArrayList<Integer>(); String awal = "", akhir = "";
                for(i=0;i<line.length();i++){
                    if(line.charAt(i)==',')lokasi.add(i);
                }
                if(j==0){
                    fileContent = line+"\n";
                }
                else{
                    if(kolom==0){ //kolom pertama
                        akhir = line.substring(lokasi.get(kolom));
                    }else if(kolom==lokasi.size()){ //kolom akhir
                        awal = line.substring(0,lokasi.get(kolom-1)+1); //kolom -1 karena 2 kata = 1 koma, 3 kata = 2 koma, 4 kata = 3 koma, dst
                    }else{ //DI tengah
                        awal = line.substring(0,lokasi.get(kolom-1)+1);
                        akhir = line.substring(lokasi.get(kolom));
                    }
                    if(j!=0) fileContent = fileContent+awal+desiredValue+akhir+"\n";
                }
                line = bufferedReader.readLine(); j++;
            }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Writing File");}
        System.out.println("=============\n"+fileContent);
    }


    public void changeAllColoumnData(String nameTxtFile, int kolom, String desiredValue, int startRow, int endRow){
        //Checking All Params is Correct
        validateFunction.validasiParamchangeAllColoumnData(kolom,startRow,endRow);

        //Edit Data Value
        String directory = System.getProperty("user.dir")+"/src";
        String absolutePath = directory + File.separator + nameTxtFile;
        String fileContent = ""; int i=0, j=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                List<Integer> lokasi = new ArrayList<Integer>(); String awal = "", akhir = "";
                for(i=0;i<line.length();i++){
                    if(line.charAt(i)==',')lokasi.add(i);
                }

                //Checking Col Param Less Than Loc
                validateFunction.validasiColoumnDataLoc(kolom,lokasi.size());

                if(j<startRow){
                    fileContent = fileContent+line+"\n";
                }
                else if(j<=endRow){
                    if(kolom==0){ //kolom pertama
                        akhir = line.substring(lokasi.get(kolom));
                    }else if(kolom==lokasi.size()){ //kolom akhir
                        awal = line.substring(0,lokasi.get(kolom-1)+1); //kolom -1 karena 2 kata = 1 koma, 3 kata = 2 koma, 4 kata = 3 koma, dst
                    }else{ //DI tengah
                        awal = line.substring(0,lokasi.get(kolom-1)+1);
                        akhir = line.substring(lokasi.get(kolom));
                    }
                    if(j!=0) fileContent = fileContent+awal+desiredValue+akhir+"\n";
                }
                else{
                    fileContent = fileContent+line+"\n";
                }
                line = bufferedReader.readLine(); j++;
            }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))){
            bufferedWriter.write(fileContent);
        } catch (IOException e) { System.out.println("Error Writing File");}
        System.out.println("=============\n"+fileContent);
    }
}

//============================== Exception Parameters ==================================
class validateFunction{
    public static void validasiParamchangeAllColoumnData(int...arrType){
        if (arrType[0]<0 || arrType[1]<0 || arrType[2]<0) throw new IllegalArgumentException("Kolom, Baris, Start Row, dan End Row Tidak Boleh Kurang Dari Nol!");
        if(arrType[1]>arrType[2]) throw new IllegalArgumentException("Start Row Must Be Greater Than Or Equals With End Row");
    }

    public static void validasiColoumnDataLoc(int... value){
        if(value[0]>value[1]) throw new IllegalArgumentException("Param Kolom Yang Anda Masukan Melebihi Index");
    }
}

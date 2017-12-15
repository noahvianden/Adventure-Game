import java.awt.*;

public class Welt  
{
    SpielObjekte[][]welt;
    
    //Gegenstände
    
    public Zettel zettel1;   //Zettel am Anfang
    public Schwerter kleinerDolch,teurerDolch;  //Dolch den man beim Dunkelwolf bekommt
    
    //Gegenstände Händler
    
    //Legolas
    
    public Boegen bogen1,bogen2;
    public LeichteRuestung leichteRuestung1,leichteRuestung2;
    
    //Ollivander
    
    public Zauberstaebe zauberstab1,zauberstab2;
    public Schutzmaentel schutzmantel1,schutzmantel2;
    
    //Balthasar
    
    public Schwerter schwert1,schwert2;
    public SchwereRuestung schwereRuestung1,schwereRuestung2;
    
    //Escobar
    
    public Boegen bogen3;
    public Schwerter schwert3;
    public Zauberstaebe zauberstab3;
    public Schwerter schwert4;
    
    
    //Personen und Gegner
    
    
    public Gegner gegner1,gegner2;  //Dunkelwolf für erste quest //gegner2 Dachs für quest mit Fluss 
    public Questgeber questgeber1,questgeber2;  //erster questgeber //questgeber Flussquest
    public Questgeber koenig;
    public Haendler legolas,ollivander,balthasar,escobar; //Händler

    public Tuer tuer1;  //Tür aus Scheune
    public Tuer tuer6;
    public Tuer tuer7;
    public Tuer tuer8;
    public Tuer tuer10;
    public Tuer tuer11;

    public Schluessel schluessel1;  //Schlüssel für Scheunentor
    public Schluessel schluessel6;
    public Schluessel schluessel7;
    public Schluessel schluessel8;
    public Schluessel schluessel10;
    public Schluessel schluessel11;

    public Gras gras,gras1,gras2,gras3;//gras1 für ersten questgeber //gras2 für gegner1(Dunkelwolf) //gras3 für questgeber mit flussquest mit Dachs
    public Baum baum;
    public See see;
    public Fluss fluss,fluss1; //fluss1 für quest mit Dachs
    public Stadtmauer stadtmauer;
    public Mauer mauer;
    public Steinweg steinweg;     
    public Hausboden hausboden,hausboden1,hausboden2,hausboden3,hausboden4,hausboden5,hausboden6; //hausboden2 für Legolas //hausboden3 für Ollivander //hausboden4 für Balthasar//hausboden5 für Escobar//hausboden6 für König
 

    public Welt(){
        welt = new SpielObjekte [50][33];

        baum = new Baum();

        welt[0][10] = baum;
        welt[0][17] = baum;
        welt[0][22] = baum;
        welt[1][0] = baum;
        welt[1][3] = baum;
        welt[1][6] = baum;
        welt[1][12] = baum;
        welt[1][15] = baum;
        welt[1][20] = baum;
        welt[1][24] = baum;
        welt[1][26] = baum;
        welt[1][28] = baum;
        welt[1][31] = baum;
        welt[2][8] = baum;
        welt[2][18] = baum;
        welt[3][3] = baum;
        welt[3][13] = baum;
        welt[3][22] = baum;
        welt[3][25] = baum;
        welt[3][27] = baum;
        welt[3][30] = baum;
        welt[4][1] = baum;
        welt[4][8] = baum;
        welt[4][17] = baum;
        welt[4][20] = baum;
        welt[5][9] = baum;
        welt[5][12] = baum;
        welt[5][15] = baum;
        welt[5][24] = baum;
        welt[5][28] = baum;
        welt[5][32] = baum;
        welt[5][8] = baum;
        welt[6][18] = baum;
        welt[6][22] = baum;
        welt[6][26] = baum;
        welt[7][20] = baum;
        welt[7][29] = baum;
        welt[8][13] = baum;
        welt[8][16] = baum;
        welt[8][25] = baum;
        welt[8][31] = baum;
        welt[9][18] = baum;
        welt[9][22] = baum;
        welt[9][27] = baum;
        welt[10][16] = baum;
        welt[10][20] = baum;
        welt[10][24] = baum;
        welt[10][32] = baum;
        welt[11][5] = baum;
        welt[11][29] = baum;
        welt[12][19] = baum;
        welt[12][22] = baum;
        welt[12][27] = baum;
        welt[12][31] = baum;
        welt[13][25] = baum;
        welt[14][12] = baum;
        welt[14][23] = baum;
        welt[14][30] = baum;
        welt[15][28] = baum;
        welt[16][14] = baum;
        welt[16][16] = baum;
        welt[16][26] = baum;
        welt[17][11] = baum;
        welt[17][30] = baum;
        welt[17][32] = baum;
        welt[18][18] = baum;
        welt[19][13] = baum;
        welt[19][16] = baum;
        welt[19][21] = baum;
        welt[20][10] = baum;
        welt[21][1] = baum;
        welt[21][5] = baum;
        welt[21][18] = baum;
        welt[21][22] = baum;
        welt[22][3] = baum;
        welt[22][26] = baum;
        welt[23][29] = baum;
        welt[24][24] = baum;
        welt[25][27] = baum;
        welt[33][13] = baum;

        see = new See();

        welt[4][5] = see;
        welt[4][6] = see;
        welt[5][3] = see;
        welt[5][4] = see;
        welt[5][5] = see;
        welt[5][6] = see;
        welt[5][7] = see;
        welt[6][1] = see;
        welt[6][2] = see;
        welt[6][3] = see;
        welt[6][4] = see;
        welt[6][5] = see;
        welt[6][6] = see;
        welt[6][7] = see;
        welt[7][0] = see;
        welt[7][1] = see;
        welt[7][2] = see;
        welt[7][3] = see;
        welt[7][4] = see;
        welt[7][5] = see;
        welt[7][6] = see;
        welt[7][7] = see;
        welt[7][8] = see;
        welt[7][9] = see;
        welt[8][0] = see;
        welt[8][1] = see;
        welt[8][2] = see;
        welt[8][3] = see;
        welt[8][4] = see;
        welt[8][5] = see;
        welt[8][7] = see;
        welt[8][8] = see;
        welt[8][9] = see;
        welt[8][10] = see;
        welt[9][0] = see;
        welt[9][1] = see;
        welt[9][2] = see;
        welt[9][3] = see;
        welt[9][7] = see;
        welt[9][8] = see;
        welt[9][9] = see;
        welt[9][10] = see;
        welt[9][11] = see;
        welt[10][0] = see;
        welt[10][1] = see;
        welt[10][2] = see;
        welt[10][8] = see;
        welt[10][9] = see;
        welt[10][10] = see;
        welt[10][11] = see;
        welt[11][0] = see;
        welt[11][1] = see;
        welt[11][7] = see;
        welt[11][8] = see;
        welt[11][9] = see;
        welt[11][10] = see;
        welt[11][11] = see;
        welt[12][0] = see;
        welt[12][1] = see;
        welt[12][2] = see;
        welt[12][7] = see;
        welt[12][8] = see;
        welt[12][9] = see;
        welt[12][10] = see;
        welt[12][11] = see;
        welt[13][0] = see;
        welt[13][1] = see;
        welt[13][2] = see;
        welt[13][3] = see;
        welt[13][6] = see;
        welt[13][7] = see;
        welt[13][8] = see;
        welt[13][9] = see;
        welt[13][10] = see;
        welt[14][0] = see;
        welt[14][1] = see;
        welt[14][2] = see;
        welt[14][3] = see;
        welt[14][4] = see;
        welt[14][5] = see;
        welt[14][6] = see;
        welt[14][7] = see;
        welt[14][8] = see;
        welt[14][9] = see;
        welt[14][10] = see;
        welt[15][0] = see;
        welt[15][1] = see;
        welt[15][2] = see;
        welt[15][3] = see;
        welt[15][4] = see;
        welt[15][5] = see;
        welt[15][6] = see;
        welt[15][7] = see;
        welt[15][8] = see;
        welt[15][9] = see;
        welt[16][1] = see;
        welt[16][2] = see;
        welt[16][3] = see;
        welt[16][4] = see;
        welt[16][5] = see;
        welt[16][6] = see;
        welt[16][7] = see;
        welt[16][8] = see;
        welt[16][9] = see;
        welt[17][2] = see;
        welt[17][3] = see;
        welt[17][4] = see;
        welt[17][5] = see;
        welt[17][6] = see;
        welt[17][7] = see;
        welt[17][8] = see;
        welt[18][3] = see;
        welt[18][4] = see;
        welt[18][5] = see;
        welt[18][6] = see;
        welt[18][7] = see;
        welt[19][5] = see;
        welt[19][6] = see;

        fluss = new Fluss();

        welt[11][12] = fluss;
        welt[11][13] = fluss;
        welt[11][14] = fluss;
        welt[12][14] = fluss;
        welt[12][15] = fluss;
        welt[13][16] = fluss;
        welt[13][17] = fluss;
        welt[14][17] = fluss;
        welt[14][18] = fluss;
        welt[15][18] = fluss;
        welt[15][19] = fluss;
        welt[15][20] = fluss;
        welt[16][20] = fluss;
        welt[16][21] = fluss;
        welt[16][22] = fluss;
        welt[16][23] = fluss;
        welt[17][23] = fluss;
        welt[17][24] = fluss;
        welt[18][24] = fluss;
        welt[18][25] = fluss;
        welt[18][26] = fluss;
        welt[19][26] = fluss;
        welt[19][27] = fluss;
        welt[19][28] = fluss;
        welt[20][28] = fluss;
        welt[20][29] = fluss;
        welt[20][30] = fluss;
        welt[21][30] = fluss;
        welt[21][31] = fluss;
        welt[22][31] = fluss;
        welt[22][32] = fluss;

        stadtmauer = new Stadtmauer();

        welt[22][9] = stadtmauer;
        welt[22][10] = stadtmauer;
        welt[22][11] = stadtmauer;
        welt[22][12] = stadtmauer;
        welt[22][14] = stadtmauer;
        welt[22][15] = stadtmauer;
        welt[22][16] = stadtmauer;
        welt[23][6] = stadtmauer;
        welt[23][7] = stadtmauer;
        welt[23][8] = stadtmauer;
        welt[23][9] = stadtmauer;
        welt[23][16] = stadtmauer;
        welt[23][17] = stadtmauer;
        welt[24][4] = stadtmauer;
        welt[24][5] = stadtmauer;
        welt[24][6] = stadtmauer;
        welt[24][17] = stadtmauer;
        welt[24][18] = stadtmauer;
        welt[24][19] = stadtmauer;
        welt[24][20] = stadtmauer;
        welt[25][2] = stadtmauer;
        welt[25][3] = stadtmauer;
        welt[25][4] = stadtmauer;
        welt[25][20] = stadtmauer;
        welt[25][21] = stadtmauer;
        welt[25][22] = stadtmauer;
        welt[26][0] = stadtmauer;
        welt[26][1] = stadtmauer;
        welt[26][2] = stadtmauer;
        welt[26][22] = stadtmauer;
        welt[26][23] = stadtmauer;
        welt[26][24] = stadtmauer;
        welt[27][24] = stadtmauer;
        welt[27][25] = stadtmauer;
        welt[27][26] = stadtmauer;
        welt[27][27] = stadtmauer;
        welt[28][27] = stadtmauer;
        welt[28][28] = stadtmauer;
        welt[28][29] = stadtmauer;
        welt[28][30] = stadtmauer;
        welt[28][31] = stadtmauer;
        welt[29][31] = stadtmauer;
        welt[29][32] = stadtmauer;

        mauer = new Mauer();

        welt[26][6] = mauer;
        welt[26][7] = mauer;
        welt[26][8] = mauer;
        welt[26][9] = mauer;
        welt[26][17] = mauer;
        welt[26][18] = mauer;
        welt[26][19] = mauer;
        welt[26][20] = mauer;
        welt[27][6] = mauer;
        welt[27][9] = mauer;
        welt[27][17] = mauer;
        welt[27][20] = mauer;
        welt[28][6] = mauer;
        welt[28][20] = mauer;
        welt[29][6] = mauer;
        welt[29][7] = mauer;
        welt[29][8] = mauer;
        welt[29][9] = mauer;
        welt[29][17] = mauer;
        welt[29][18] = mauer;
        welt[29][19] = mauer;
        welt[29][20] = mauer;
        welt[30][24] = mauer;
        welt[30][25] = mauer;
        welt[30][26] = mauer;
        welt[30][27] = mauer;
        welt[31][2] = mauer;
        welt[31][3] = mauer;
        welt[31][4] = mauer;
        welt[31][5] = mauer;
        welt[31][21] = mauer;
        welt[31][22] = mauer;
        welt[31][23] = mauer;
        welt[31][24] = mauer;
        welt[31][27] = mauer;
        welt[32][2] = mauer;
        welt[32][5] = mauer;
        welt[32][21] = mauer;
        welt[32][24] = mauer;
        welt[32][27] = mauer;
        welt[33][2] = mauer;
        welt[33][27] = mauer;
        welt[34][2] = mauer;
        welt[34][3] = mauer;
        welt[34][4] = mauer;
        welt[34][5] = mauer;
        welt[34][21] = mauer;
        welt[34][22] = mauer;
        welt[34][23] = mauer;
        welt[34][24] = mauer;
        welt[34][27] = mauer;
        welt[35][24] = mauer;
        welt[35][25] = mauer;
        welt[35][26] = mauer;
        welt[35][27] = mauer;
        welt[37][2] = mauer;
        welt[37][3] = mauer;
        welt[37][4] = mauer;
        welt[37][5] = mauer;
        welt[37][21] = mauer;
        welt[37][22] = mauer;
        welt[37][23] = mauer;
        welt[37][24] = mauer;
        welt[38][2] = mauer;
        welt[38][24] = mauer;
        welt[38][25] = mauer;
        welt[39][2] = mauer;
        welt[39][5] = mauer;
        welt[39][21] = mauer;
        welt[39][25] = mauer;
        welt[39][26] = mauer;
        welt[40][2] = mauer;
        welt[40][3] = mauer;
        welt[40][4] = mauer;
        welt[40][5] = mauer;
        welt[40][21] = mauer;
        welt[40][22] = mauer;
        welt[40][23] = mauer;
        welt[40][26] = mauer;
        welt[40][27] = mauer;
        welt[41][11] = mauer;
        welt[41][15] = mauer;
        welt[41][23] = mauer;
        welt[41][24] = mauer;
        welt[41][27] = mauer;
        welt[42][10] = mauer;
        welt[42][11] = mauer;
        welt[42][15] = mauer;
        welt[42][16] = mauer;
        welt[42][24] = mauer;
        welt[42][25] = mauer;
        welt[42][27] = mauer;
        welt[43][8] = mauer;
        welt[43][9] = mauer;
        welt[43][10] = mauer;
        welt[43][16] = mauer;
        welt[43][17] = mauer;
        welt[43][18] = mauer;
        welt[43][25] = mauer;
        welt[43][26] = mauer;
        welt[43][27] = mauer;
        welt[44][4] = mauer;
        welt[44][5] = mauer;
        welt[44][6] = mauer;
        welt[44][8] = mauer;
        welt[44][18] = mauer;
        welt[44][20] = mauer;
        welt[44][21] = mauer;
        welt[44][22] = mauer;
        welt[45][4] = mauer;
        welt[45][6] = mauer;
        welt[45][7] = mauer;
        welt[45][8] = mauer;
        welt[45][18] = mauer;
        welt[45][19] = mauer;
        welt[45][20] = mauer;
        welt[45][22] = mauer;
        welt[45][26] = mauer;
        welt[45][27] = mauer;
        welt[45][28] = mauer;
        welt[46][4] = mauer;
        welt[46][22] = mauer;
        welt[46][28] = mauer;
        welt[47][4] = mauer;
        welt[47][6] = mauer;
        welt[47][7] = mauer;
        welt[47][8] = mauer;
        welt[47][18] = mauer;
        welt[47][19] = mauer;
        welt[47][20] = mauer;
        welt[47][22] = mauer;
        welt[47][26] = mauer;
        welt[47][27] = mauer;
        welt[47][28] = mauer;
        welt[48][4] = mauer;
        welt[48][5] = mauer;
        welt[48][6] = mauer;
        welt[48][8] = mauer;
        welt[48][9] = mauer;
        welt[48][10] = mauer;
        welt[48][11] = mauer;
        welt[48][12] = mauer;
        welt[48][13] = mauer;
        welt[48][14] = mauer;
        welt[48][15] = mauer;
        welt[48][16] = mauer;
        welt[48][17] = mauer;
        welt[48][18] = mauer;
        welt[48][20] = mauer;
        welt[48][21] = mauer;
        welt[48][22] = mauer;
        welt[41][12] = mauer;
        welt[41][14] = mauer;

        steinweg = new Steinweg();

        welt[22][13] = steinweg;
        welt[23][13] = steinweg;
        welt[24][13] = steinweg;
        welt[25][13] = steinweg;
        welt[26][13] = steinweg;
        welt[27][13] = steinweg;
        welt[28][10] = steinweg;
        welt[28][11] = steinweg;
        welt[28][12] = steinweg;
        welt[28][13] = steinweg;
        welt[28][14] = steinweg;
        welt[28][15] = steinweg;
        welt[28][16] = steinweg;
        welt[29][13] = steinweg;
        welt[30][13] = steinweg;
        welt[31][13] = steinweg;
        welt[32][12] = steinweg;
        welt[32][13] = steinweg;
        welt[32][14] = steinweg;
        welt[33][6] = steinweg;
        welt[33][7] = steinweg;
        welt[33][8] = steinweg;
        welt[33][9] = steinweg;
        welt[33][10] = steinweg;
        welt[33][11] = steinweg;
        welt[33][12] = steinweg;
        welt[33][14] = steinweg;
        welt[33][15] = steinweg;
        welt[33][16] = steinweg;
        welt[33][17] = steinweg;
        welt[33][18] = steinweg;
        welt[33][19] = steinweg;
        welt[33][20] = steinweg;
        welt[34][12] = steinweg;
        welt[34][13] = steinweg;
        welt[34][14] = steinweg;
        welt[35][13] = steinweg;
        welt[36][13] = steinweg;
        welt[37][13] = steinweg;
        welt[38][6] = steinweg;
        welt[38][7] = steinweg;
        welt[38][8] = steinweg;
        welt[38][9] = steinweg;
        welt[38][10] = steinweg;
        welt[38][11] = steinweg;
        welt[38][12] = steinweg;
        welt[38][13] = steinweg;
        welt[38][14] = steinweg;
        welt[38][15] = steinweg;
        welt[38][16] = steinweg;
        welt[38][17] = steinweg;
        welt[38][18] = steinweg;
        welt[38][19] = steinweg;
        welt[38][20] = steinweg;
        welt[39][13] = steinweg;
        welt[40][13] = steinweg;

        hausboden = new Hausboden();

        tuer1 = new Tuer(false,"Du kommst an ein abgeschlossenes Tor. Ihr Schloss ist sehr verrostet, wie ihr Schlüssel vermutlich auch.","Der verrostete Schlüssel dreht sich langsam und quietschend im Schlüsselloch und das Tor geht knarrend auf.",3,"altes rostiges Scheunentor",1);
        tuer6 = new Tuer(false,"","",3,"Tür 6",6);
        tuer7 = new Tuer(false,"","",3,"Tür 7",7);
        tuer8 = new Tuer(false,"","",3,"Tür 8",8);
       
        tuer10 = new Tuer(false,"","",1,"Tür 10",10);
        tuer11 = new Tuer(false,"","",3,"Tür 11",11);

        schluessel1 = new Schluessel("alle",0,"Rostiger Schlüssel",false,1,0,"");
        schluessel6 = new Schluessel("alle",0,"Schlüssel6",false,6,0,"");
        schluessel7 = new Schluessel("alle",0,"Schlüssel7",false,7,0,"");
        schluessel8 = new Schluessel("alle",0,"Schlüssel8",false,8,0,"");
        
        schluessel10 = new Schluessel("alle",0,"Schlüssel10",false,10,0,"");
        schluessel11 = new Schluessel("alle",0,"Schlüssel11",false,11,0,"");

        welt[27][7] = hausboden;
        welt[27][8] = hausboden;
        welt[28][7] = hausboden;
        welt[28][8] = hausboden;
        welt[28][9] = hausboden;

        welt[28][17] = hausboden;
        welt[28][18] = hausboden;
        welt[28][19] = hausboden;
        welt[27][18] = hausboden;
        welt[27][19] = hausboden;

        welt[32][3] = hausboden;
        welt[32][4] = hausboden;
        welt[33][3] = hausboden;
        welt[33][4] = hausboden;
        welt[33][5] = hausboden;

        welt[38][3] = hausboden;
        welt[38][4] = hausboden;
        welt[38][5] = hausboden;
        welt[39][3] = hausboden;
        welt[39][4] = hausboden;

        welt[31][25] = hausboden;
        welt[31][26] = hausboden;
        welt[32][22] = hausboden;
        welt[32][23] = hausboden;
        welt[32][25] = hausboden;
        welt[32][26] = hausboden;
        welt[33][21] = tuer6;
        welt[33][22] = hausboden;
        welt[33][23] = hausboden;
        welt[33][24] = tuer7;
        welt[33][25] = hausboden;
        welt[33][26] = hausboden;
        welt[34][25] = hausboden;
        welt[34][26] = hausboden;

        welt[38][21] = tuer8;
        welt[38][22] = hausboden;
        welt[38][23] = hausboden;
        welt[39][22] = hausboden;
        welt[39][23] = hausboden;
        welt[39][24] = hausboden;
        welt[40][24] = hausboden;
        welt[40][25] = hausboden;
        welt[41][25] = hausboden;
        welt[41][26] = hausboden;
        welt[42][26] = hausboden;

        welt[41][13] = hausboden;
        welt[42][12] = hausboden;
        welt[42][13] = hausboden;
        welt[42][14] = hausboden;
        welt[43][11] = hausboden;
        welt[43][12] = hausboden;
        welt[43][13] = hausboden;
        welt[43][14] = hausboden;
        welt[43][15] = hausboden;
        welt[44][9] = hausboden;
        welt[44][10] = hausboden;
        welt[44][11] = hausboden;
        welt[44][12] = hausboden;
        welt[44][13] = hausboden;
        welt[44][14] = hausboden;
        welt[44][15] = hausboden;
        welt[44][16] = hausboden;
        welt[44][17] = hausboden;
        welt[45][5] = hausboden;
        welt[45][9] = hausboden;
        welt[45][10] = hausboden;
        welt[45][11] = hausboden;
        welt[45][12] = hausboden;
        welt[45][13] = hausboden;
        welt[45][14] = hausboden;
        welt[45][15] = hausboden;
        welt[45][16] = hausboden;
        welt[45][17] = hausboden;
        welt[45][21] = hausboden;
        welt[46][5] = hausboden;
        welt[46][6] = hausboden;
        welt[46][7] = hausboden;
        welt[46][8] = tuer10;
        welt[46][9] = hausboden;
        welt[46][10] = hausboden;
        welt[46][11] = hausboden;
        welt[46][12] = hausboden;
        welt[46][13] = hausboden;
        welt[46][14] = hausboden;
        welt[46][15] = hausboden;
        welt[46][16] = hausboden;
        welt[46][17] = hausboden;
        welt[46][18] = tuer11;
        welt[46][19] = hausboden;
        welt[46][20] = hausboden;
        welt[46][21] = hausboden;
        welt[47][5] = hausboden;
        welt[47][9] = hausboden;
        welt[47][10] = hausboden;
        welt[47][11] = hausboden;
        welt[47][12] = hausboden;
        welt[47][13] = hausboden;
        welt[47][14] = hausboden;
        welt[47][15] = hausboden;
        welt[47][16] = hausboden;
        welt[47][17] = hausboden;
        welt[47][21] = hausboden;
        
        //Gegenstände 
        
        hausboden1 = new Hausboden();
        hausboden1.setInhalt(schluessel1);
        welt[46][27] = hausboden1;
        welt[46][26] = tuer1;
        
        zettel1 = new Zettel("kleine Botschaft",0,"... Jagdbericht vom 24.02.1389: Wilde Wesen lauern im Düsterwald vor den Toren von Kingsbridge...");
        tuer1.setInhalt(zettel1);
        
        gras2 = new Gras();
        welt[43][24] = gras2;
        kleinerDolch = new Schwerter("alle",1,"kleiner Dolch",false,4,"");
        gras2.setInhalt(kleinerDolch);
        
        teurerDolch = new Schwerter("alle",2,"Rubindolch",false,20,"");
        
        //Händler
        
        hausboden2 = new Hausboden();
        welt[33][3] = hausboden2;
        legolas = new Haendler("Guten Tag, Freund! Möchtest du einen Bogen oder eine bequeme Rüstung kaufen?","Legolas - Elb");
        hausboden2.setHaendler(legolas);
        
        bogen1 = new Boegen("Schütze",5,"Elbischer Kurzbogen",false,10,"");
        legolas.setWaren(bogen1,0);
        
        bogen2 = new Boegen("Schütze",8,"Elbischer Langbogen",false,17,"");
        legolas.setWaren(bogen2,1);
        
        leichteRuestung1 = new LeichteRuestung("Schütze",1,"Leichte Stofftracht",3,true,5,"");
        legolas.setWaren(leichteRuestung1,2);
        
        leichteRuestung2 = new LeichteRuestung("Schütze",2,"Leichte Ledertracht",7,true,10,"");
        legolas.setWaren(leichteRuestung2,3);
        
        hausboden3 = new Hausboden();
        welt[39][3] = hausboden3;
        ollivander = new Haendler("Willkommen in meinem bescheidenen Laden, sieh dich ruhig um.","Ollivander - Weiser Magier");
        hausboden3.setHaendler(ollivander);
        
        zauberstab1 = new Zauberstaebe("Magier",3,"Alter Zauberstab",false,6,"");
        ollivander.setWaren(zauberstab1,0);
        
        zauberstab2 = new Zauberstaebe("Magier",6,"Eichenstab",false,10,"");
        ollivander.setWaren(zauberstab2,1);
        
        schutzmantel1 = new Schutzmaentel("Magier",1,"Zerfetzter Mantel",5,true,10,"");
        ollivander.setWaren(schutzmantel1,2);
        
        schutzmantel2 = new Schutzmaentel("Magier",2,"Mantel aus Einhornfell",9,true,16,"");
        ollivander.setWaren(schutzmantel2,3);
        
        hausboden4 = new Hausboden();
        welt[28][7] = hausboden4;
        balthasar = new Haendler("Gott zum Gruß edler Herr. Brauchen Sie ein paar gute Klingen, oder eine Stabile Rüstung?","Balthasar - Schmied");
        hausboden4.setHaendler(balthasar);
        
        schwert1 = new Schwerter("Krieger",4,"Rostiges Schwert",false,8,"");
        balthasar.setWaren(schwert1,0);
        
        schwert2 = new Schwerter("Krieger",8,"Langschwert",false,15,"");
        balthasar.setWaren(schwert2,1);
        
        schwereRuestung1 = new SchwereRuestung("Krieger",1,"Verbeulte Ritterrüstung",6,true,11,"");
        balthasar.setWaren(schwereRuestung1,2);
        
        schwereRuestung2 = new SchwereRuestung("Krieger",2,"Neue Rüstung",12,true,20,"");
        balthasar.setWaren(schwereRuestung2,3);
        
        hausboden5 = new Hausboden();
        welt[28][19] = hausboden5;
        escobar = new Haendler("Hey, du. Ich hab die besten Waffen der Stadt, das kostet dich aber auch etwas. Und das bleibt unter uns...","Escobar - Hehler");
        hausboden5.setHaendler(escobar);
        
        bogen3 = new Boegen("Schütze",30,"Pistole von Lucky Luke",false,70,"Hiermit schießt du schneller als dein Schatten!");
        escobar.setWaren(bogen3,0);
        
        schwert3 = new Schwerter("Krieger",30,"Excalibur",false,70,"Bist du dieses Schwertes würdig?");
        escobar.setWaren(schwert3,1);
        
        zauberstab3 = new Zauberstaebe("Magier",30,"Elderstab",false,70,"Gehörte einst: Albus Percival Wulfric Brian Dumbledore");
        escobar.setWaren(zauberstab3,2);
        
        schwert4 = new Schwerter("Alle",30,"Brutus` Dolch",false,70,"Brachte einen Tyrannen zu Fall!");
        escobar.setWaren(schwert4,3);
        
        //Personen und Gegner
        
        
        gras1 = new Gras();
        questgeber1 = new Questgeber("Erhardt - Bauer","Hey, du. Ein Dunkelwolf hat sich in die Stadt geschlichen und meine Schafe angegriffen. Kümmerst du dich drum? Zuletzt habe ich ihn westlich von hier gesehen.","Hast du dich um den Dunkelwolf gekümmert? Nein? Worauf wartest du dann noch?","Danke für deine Hilfe! Ich habe leider nichts für dich, aber der König sucht einen tapferen Helden, wie dich, für seine Mission.","Danke noch mal für deine Hilfe, du hast meine Existenz gerettet!");
        welt[46][24] = gras1;
        gras1.setQuestgeber(questgeber1);
        
        gegner1 = new Gegner(10,1,"Dunkelwolf");
        gras2.setGegner(gegner1);
        
        hausboden6 = new Hausboden();
        welt[47][13]=hausboden6;
        koenig = new Questgeber("Ludwig XIV - König","Seid ihr ein Mann von Ehre? Wilde Bestien fallen in unser Land ein und ich brauche einen tapferen Krieger der sich um die Plage kümmert! Kümmer dich bitte um alle Monster und kehre dann zu mir zurück!","Worauf wartest du noch? Du hast noch nicht alle Monster erledigt.","Du hast unserem Königreich einen großen Dienst erwiesen und alle Bürger dieses Landes werden für immer in deiner Schuld stehen.","Du hast dir die Anerkennung aller Menschen hier verdient und solltest dich zur Ruhe setzen.");
        hausboden6.setQuestgeber(koenig);
        
        fluss1 = new Fluss();
        gras3 = new Gras();
        welt[13][15] = fluss1;
        welt[17][21] = gras3;
        questgeber2 = new Questgeber("Gretchen - Mädchen","HILFE! Ein Dachs hat den Dolch geklaut den ich hier gefunden habe und ist flussabwärts - in Richtung Norden - geschwommen. Holst du ihn zurück? Vielleicht darfst du ihn dann sogar behalten...","Je länger du wartest, desto weiter schwimmt der Dachs weg.","Da bist du ja wieder. Kannst den Dolch wie versprochen behalten. Mein Vater mag es nicht, wenn ich mit sowas spiele... :(","Keine Zeit, muss noch ein paar Beeren sammeln.");
        gegner2 = new Gegner(15,2,"Dachs");
        fluss1.setGegner(gegner2);
        fluss1.setInhalt(teurerDolch);
        gras3.setQuestgeber(questgeber2);
        

        gras = new Gras();
        for(int x=0; x<=49;x++){
            for(int y=0; y<=32;y++){
                if(welt[x][y] == null){
                    welt[x][y] = gras;
                }
            }
        }
    }

    public void setContent(int x, int y, SpielObjekte pObjekt){
        welt[x][y]=pObjekt;
    }

    public SpielObjekte getContent(int x, int y){
        return welt[x][y];
    }

}

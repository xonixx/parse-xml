package info.xonix.xml;

import info.xonix.xml.elem.Tag;

import java.util.List;

/**
 * User: gubarkov
 * Date: 19.08.12
 * Time: 0:33
 */
public class Tst {
    public static void main(String[] args) {
//        System.out.println((int)(char)-1);

//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');

        final Lexer lexer = new Lexer();
//        System.out.println(lexer.lex("< aaa b=\"c\" />"));
//        System.out.println(lexer.lex("<aaa><!--bbb - <cc>--></aaa>"));
//        System.out.println(lexer.lex("<aaa>QQQ</zzz>"));
//        System.out.println(lexer.lex("<  aaa  >  QQQ  </ zzz \t>"));
//        System.out.println(lexer.lex("<  aaa  >  QQQ  <zzz> <FFF / > KKK </zzzz></bbb>"));
//        System.out.println(lexer.lex(
//                "<  aaa bbb  = \"ccc\"  ddd =  \"eeee\"  >  QQQ  <zzz> <FFF  /> KKK </ zzzz></bbb>"));

        /*System.out.println(lexer.lex("<recipe name=\"хлеб\" preptime=\"5\" cooktime=\"180\">\n" +
                "  <title>Простой хлеб</title>\n" +
                "  <composition>\n" +
                "    <ingredient amount=\"3\" unit=\"стакан\">Мука</ingredient>\n" +
                "    <ingredient amount=\"0.25\" unit=\"грамм\">Дрожжи</ingredient>\n" +
                "    <ingredient amount=\"1.5\" unit=\"стакан\">Тёплая вода</ingredient>\n" +
                "    <ingredient amount=\"1\" unit=\"чайная ложка\">Соль</ingredient>\n" +
                "  </composition>\n" +
                "  <instructions>\n" +
                "    <step>Смешать все ингредиенты и тщательно замесить.</step>\n" +
                "    <step>Закрыть тканью и оставить на один час в тёплом помещении.</step>\n" +
                "    <!-- <step>Почитать вчерашнюю газету.</step> - это сомнительный шаг... -->\n" +
                "    <step>Замесить ещё раз, положить на противень и поставить в духовку.</step>\n" +
                "  </instructions>\n" +
                "</recipe>"));*/

//        lexparse("<aaa>BBB</aaa>");
//        lexparse("<aaa  qqq=\"zzz\">BBB</aaa>");
//        lexparse("<a><KKK/></a>");
//        lexparse("<aaa  qqq=\"zzz\">BBB<KKK/></aaa>");

//        lexparse("<a><b>c</b></a>");

//        lexparse("<a a=\"'\"></a>");
//        lexparse("<a a = '\"' b=\"''\" ></a>");

        /*lexparse("<recipe name=\"хлеб\" preptime=\"5\" cooktime=\"180\">\n" +
                "  <title>Простой хлеб</title>\n" +
                "  <composition>\n" +
                "    <ingredient amount=\"3\" unit=\"стакан\">Мука</ingredient>\n" +
                "    <ingredient amount=\"0.25\" unit=\"грамм\">Дрожжи</ingredient>\n" +
                "    <ingredient amount=\"1.5\" unit=\"стакан\">Тёплая вода</ingredient>\n" +
                "    <ingredient amount=\"1\" unit=\"чайная ложка\">Соль</ingredient>\n" +
                "  </composition>\n" +
                "  <instructions>\n" +
                "    <step>Смешать все ингредиенты и тщательно замесить.</step>\n" +
                "    <step>Закрыть тканью и оставить на один час в тёплом помещении.</step>\n" +
                "    <!-- <step>Почитать вчерашнюю газету.</step> - это сомнительный шаг... -->\n" +
                "    <step>Замесить ещё раз, положить на противень и поставить в духовку.</step>\n" +
                "  </instructions>\n" +
                "</recipe>");*/

//        catalog();
        migration();
    }

    private static void lexparse(String xml) {
        Lexer lexer = new Lexer();
        final List<Token> tokens = lexer.lex(xml);

        System.out.println(tokens);

        Parser parser = new Parser();
        final Tag tag = parser.parse(tokens);

        System.out.println(tag);
    }

    private static void catalog() {
        lexparse("<!-- Edited by XMLSpy® -->\n" +
                "<CATALOG>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Empire Burlesque</TITLE>\n" +
                "\t\t<ARTIST>Bob Dylan</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>Columbia</COMPANY>\n" +
                "\t\t<PRICE>10.90</PRICE>\n" +
                "\t\t<YEAR>1985</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Hide your heart</TITLE>\n" +
                "\t\t<ARTIST>Bonnie Tyler</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>CBS Records</COMPANY>\n" +
                "\t\t<PRICE>9.90</PRICE>\n" +
                "\t\t<YEAR>1988</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Greatest Hits</TITLE>\n" +
                "\t\t<ARTIST>Dolly Parton</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>RCA</COMPANY>\n" +
                "\t\t<PRICE>9.90</PRICE>\n" +
                "\t\t<YEAR>1982</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Still got the blues</TITLE>\n" +
                "\t\t<ARTIST>Gary Moore</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Virgin records</COMPANY>\n" +
                "\t\t<PRICE>10.20</PRICE>\n" +
                "\t\t<YEAR>1990</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Eros</TITLE>\n" +
                "\t\t<ARTIST>Eros Ramazzotti</ARTIST>\n" +
                "\t\t<COUNTRY>EU</COUNTRY>\n" +
                "\t\t<COMPANY>BMG</COMPANY>\n" +
                "\t\t<PRICE>9.90</PRICE>\n" +
                "\t\t<YEAR>1997</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>One night only</TITLE>\n" +
                "\t\t<ARTIST>Bee Gees</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Polydor</COMPANY>\n" +
                "\t\t<PRICE>10.90</PRICE>\n" +
                "\t\t<YEAR>1998</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Sylvias Mother</TITLE>\n" +
                "\t\t<ARTIST>Dr.Hook</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>CBS</COMPANY>\n" +
                "\t\t<PRICE>8.10</PRICE>\n" +
                "\t\t<YEAR>1973</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Maggie May</TITLE>\n" +
                "\t\t<ARTIST>Rod Stewart</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Pickwick</COMPANY>\n" +
                "\t\t<PRICE>8.50</PRICE>\n" +
                "\t\t<YEAR>1990</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Romanza</TITLE>\n" +
                "\t\t<ARTIST>Andrea Bocelli</ARTIST>\n" +
                "\t\t<COUNTRY>EU</COUNTRY>\n" +
                "\t\t<COMPANY>Polydor</COMPANY>\n" +
                "\t\t<PRICE>10.80</PRICE>\n" +
                "\t\t<YEAR>1996</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>When a man loves a woman</TITLE>\n" +
                "\t\t<ARTIST>Percy Sledge</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>Atlantic</COMPANY>\n" +
                "\t\t<PRICE>8.70</PRICE>\n" +
                "\t\t<YEAR>1987</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Black angel</TITLE>\n" +
                "\t\t<ARTIST>Savage Rose</ARTIST>\n" +
                "\t\t<COUNTRY>EU</COUNTRY>\n" +
                "\t\t<COMPANY>Mega</COMPANY>\n" +
                "\t\t<PRICE>10.90</PRICE>\n" +
                "\t\t<YEAR>1995</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>1999 Grammy Nominees</TITLE>\n" +
                "\t\t<ARTIST>Many</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>Grammy</COMPANY>\n" +
                "\t\t<PRICE>10.20</PRICE>\n" +
                "\t\t<YEAR>1999</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>For the good times</TITLE>\n" +
                "\t\t<ARTIST>Kenny Rogers</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Mucik Master</COMPANY>\n" +
                "\t\t<PRICE>8.70</PRICE>\n" +
                "\t\t<YEAR>1995</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Big Willie style</TITLE>\n" +
                "\t\t<ARTIST>Will Smith</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>Columbia</COMPANY>\n" +
                "\t\t<PRICE>9.90</PRICE>\n" +
                "\t\t<YEAR>1997</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Tupelo Honey</TITLE>\n" +
                "\t\t<ARTIST>Van Morrison</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Polydor</COMPANY>\n" +
                "\t\t<PRICE>8.20</PRICE>\n" +
                "\t\t<YEAR>1971</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Soulsville</TITLE>\n" +
                "\t\t<ARTIST>Jorn Hoel</ARTIST>\n" +
                "\t\t<COUNTRY>Norway</COUNTRY>\n" +
                "\t\t<COMPANY>WEA</COMPANY>\n" +
                "\t\t<PRICE>7.90</PRICE>\n" +
                "\t\t<YEAR>1996</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>The very best of</TITLE>\n" +
                "\t\t<ARTIST>Cat Stevens</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Island</COMPANY>\n" +
                "\t\t<PRICE>8.90</PRICE>\n" +
                "\t\t<YEAR>1990</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Stop</TITLE>\n" +
                "\t\t<ARTIST>Sam Brown</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>A and M</COMPANY>\n" +
                "\t\t<PRICE>8.90</PRICE>\n" +
                "\t\t<YEAR>1988</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Bridge of Spies</TITLE>\n" +
                "\t\t<ARTIST>T'Pau</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Siren</COMPANY>\n" +
                "\t\t<PRICE>7.90</PRICE>\n" +
                "\t\t<YEAR>1987</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Private Dancer</TITLE>\n" +
                "\t\t<ARTIST>Tina Turner</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>Capitol</COMPANY>\n" +
                "\t\t<PRICE>8.90</PRICE>\n" +
                "\t\t<YEAR>1983</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Midt om natten</TITLE>\n" +
                "\t\t<ARTIST>Kim Larsen</ARTIST>\n" +
                "\t\t<COUNTRY>EU</COUNTRY>\n" +
                "\t\t<COMPANY>Medley</COMPANY>\n" +
                "\t\t<PRICE>7.80</PRICE>\n" +
                "\t\t<YEAR>1983</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Pavarotti Gala Concert</TITLE>\n" +
                "\t\t<ARTIST>Luciano Pavarotti</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>DECCA</COMPANY>\n" +
                "\t\t<PRICE>9.90</PRICE>\n" +
                "\t\t<YEAR>1991</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>The dock of the bay</TITLE>\n" +
                "\t\t<ARTIST>Otis Redding</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>Atlantic</COMPANY>\n" +
                "\t\t<PRICE>7.90</PRICE>\n" +
                "\t\t<YEAR>1987</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Picture book</TITLE>\n" +
                "\t\t<ARTIST>Simply Red</ARTIST>\n" +
                "\t\t<COUNTRY>EU</COUNTRY>\n" +
                "\t\t<COMPANY>Elektra</COMPANY>\n" +
                "\t\t<PRICE>7.20</PRICE>\n" +
                "\t\t<YEAR>1985</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Red</TITLE>\n" +
                "\t\t<ARTIST>The Communards</ARTIST>\n" +
                "\t\t<COUNTRY>UK</COUNTRY>\n" +
                "\t\t<COMPANY>London</COMPANY>\n" +
                "\t\t<PRICE>7.80</PRICE>\n" +
                "\t\t<YEAR>1987</YEAR>\n" +
                "\t</CD>\n" +
                "\t<CD>\n" +
                "\t\t<TITLE>Unchain my heart</TITLE>\n" +
                "\t\t<ARTIST>Joe Cocker</ARTIST>\n" +
                "\t\t<COUNTRY>USA</COUNTRY>\n" +
                "\t\t<COMPANY>EMI</COMPANY>\n" +
                "\t\t<PRICE>8.20</PRICE>\n" +
                "\t\t<YEAR>1987</YEAR>\n" +
                "\t</CD>\n" +
                "</CATALOG>\n");
    }

    private static void migration() {
        lexparse("<migration urlid=\"http://www.microsoft.com/migration/1.0/migxmlext/migapp\">\n" +
                "  <component type=\"Application\">\n" +
                "    <!-- Name of the application -->\n" +
                "    <displayName>Some Application</displayName>\n" +
                "    <!-- Specify whether the environment variables exist in the context of user or system or both -->\n" +
                "    <environment context=\"System\">\n" +
                "      <!-- create the environment variables -->\n" +
                "      <variable name=\"myVar1\">\n" +
                "        <!-- simple text value assignment to a variable -->\n" +
                "        <text>value</text>\n" +
                "      </variable>\n" +
                "      <variable name=\"myAppExePath\">\n" +
                "        <!-- make a call to in-built helper function to get a value from a reg key and assign that value to the variable -->\n" +
                "        <script>MigXMLHelper.GetStringContent(\"Registry\",\"HKLM\\Software\\MyApp\\Installer [EXEPATH]\")</script>\n" +
                "      </variable>\n" +
                "    </environment>\n" +
                "    <role role=\"Settings\">\n" +
                "      <detects>\n" +
                "        <!-- all of these checks must be true for the component to be detected -->\n" +
                "        <detect>\n" +
                "          <!-- make a call to in-built helper function to check to see if an object exists or not -->\n" +
                "          <condition>MigXMLHelper.DoesObjectExist(\"Registry\",\"HKLM\\Software\\MyApp [win32_version]\")</condition>\n" +
                "        </detect>\n" +
                "        <detect>\n" +
                "          <!-- either of these checks must be true for the component to be detected -->\n" +
                "          <!-- make a call to in-built helper function to check to see if a file version matches or not -->\n" +
                "          <condition>MigXMLHelper.DoesFileVersionMatch(\"%MyAppExePath%\",\"ProductVersion\",\"8.*\")</condition>\n" +
                "          <condition>MigXMLHelper.DoesFileVersionMatch(\"%MyAppExePath%\",\"ProductVersion\",\"9.*\")</condition>\n" +
                "        </detect>\n" +
                "      </detects>\n" +
                "      <!-- describe the rules that will be executed during migration of this component and the context, whether user, system or both -->\n" +
                "      <rules context=\"User\">\n" +
                "        <!-- delete objects specified in the object set on the destination machine before applying source objects -->\n" +
                "        <destinationCleanup>\n" +
                "          <!-- describe the pattern for the list of objects to be deleted -->\n" +
                "          <objectSet>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp\\Toolbar\\* [*]</pattern>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp\\ListView\\* [*]</pattern>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp [ShowTips]</pattern>\n" +
                "          </objectSet>\n" +
                "        </destinationCleanup>\n" +
                "        <!-- specify which set of objects should be migrated -->\n" +
                "        <include>\n" +
                "          <!-- describe the pattern for the list of objects to be included -->\n" +
                "          <objectSet>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp\\Toolbar\\* [*]</pattern>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp\\ListView\\* [*]</pattern>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp [ShowTips]</pattern>\n" +
                "          </objectSet>\n" +
                "        </include>\n" +
                "        <!-- specify which set of objects should not be migrated -->\n" +
                "        <exclude>\n" +
                "          <!-- describe the pattern for the list of objects to be excluded from migration -->\n" +
                "          <objectSet>\n" +
                "            <pattern type=\"Registry\">HKCU\\Software\\MyApp [Display]</pattern>\n" +
                "          </objectSet>\n" +
                "        </exclude>\n" +
                "      </rules>\n" +
                "    </role>\n" +
                "  </component>\n" +
                "</migration>");
    }
}

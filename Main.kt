// Exercises For Programmers by Brian P. Hogan
// Exercise 42: Parsing a Data File
// James Hill, Houston, Texas, 2022
// GitHub: jhill1971 Twitter: @count_BASIC

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.nio.file.Files.newBufferedReader
import java.nio.file.Paths

/** Construct a program that reads in the data file (names2.csv). Process and display the records
 * For this exercise I have added the following dependency to the gradle file:
 * implementation ("org.apache.commons:commons-csv:1.5")
 **/

fun main() {
    /* Creating a buffered reader object that reads the file. */
    val bufferedReader = newBufferedReader(
        Paths.get("C:\\Users\\ikon1\\IdeaProjects\\Exercise42\\src\\main\\resources\\names2.csv")
    )

    /* Creating a parser object */
    val csvParser = CSVParser(
        bufferedReader, CSVFormat.DEFAULT
            .withRecordSeparator("\n")
            .withFirstRecordAsHeader()
    )
    // Print Header
    System.out.format("%-15s%-15s%-15s\n", "LAST", "FIRST", "SALARY")
    for (x in 0..35) {
        print("-")
    }
    println()

    /* Iterate through the CSV parser object and get the values of the columns */
    for (csvRecord in csvParser) {
        val lastName = csvRecord.get("Last")
        val firstName = csvRecord.get("First")
        val salary = csvRecord.get("Salary").toInt()
        /* Print the values of the columns in the CSV file using System.out.format */
        System.out.format("%-15s%-15s%-15s\n", "${lastName}", "${firstName}", "$${salary}")
    }
}
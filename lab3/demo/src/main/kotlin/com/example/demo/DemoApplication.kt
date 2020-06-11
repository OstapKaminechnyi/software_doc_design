package com.example.demo

import com.example.demo.model.*
import com.example.demo.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.io.BufferedReader
import java.io.FileReader

@SpringBootApplication
class DemoApplication{

    @Autowired
    lateinit var courseServices: CourseServices

    @Autowired
    lateinit var courseGroupServices: CourseGroupServices

    @Autowired
    lateinit var institutionServices: InstitutionServices

    @Autowired
    lateinit var lecturerServices: LecturerServices

    @Autowired
    lateinit var topicServices: TopicServices

    @Bean
    fun run() = CommandLineRunner {
//        readCsv()
    }

    fun readCsv() {
        readCourse()
        readCourseGroup()
        readInstitution()
        readLecturer()
        readTopic()
    }

    fun readCourse() {
        try {
            var line: String?

            val fileReader = BufferedReader(FileReader("edx.csv"))

            // Read CSV header

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            var tokens = line.split(",")
            while (line != null && !tokens.contains("courseGroupId")) {
                tokens = line.split(",")
                if (tokens.size > 0) {
                    if (line.startsWith("courseId")) {
                        while (!tokens.contains("courseGroupId")) {
                            line = fileReader.readLine()
                            tokens = line.split(",")
//                            println(tokens[5])
                            val course = Course(tokens[0].toInt(), tokens[1], tokens[2], tokens[3], tokens[4])
                            courseServices.save(course)
                        }
                    }
                }
                line = fileReader.readLine()
            }
        } catch (e: Exception) {

        }


    }

    fun readCourseGroup() {

        try {
            var line: String?

            val fileReader = BufferedReader(FileReader("edx.csv"))

            // Read CSV header
            fileReader.readLine()

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            var tokens = line.split(",")
            while (line != null && !tokens.contains("name")) {
                tokens = line.split(",")
                if (tokens.size > 0) {
                    if (line.startsWith("courseGroupId")) {
                        while (!tokens.contains("name")) {
                            line = fileReader.readLine()
                            tokens = line.split(",")
//                            println(tokens[1])
                            val courseGroup = CourseGroup(tokens[0].toInt(), tokens[1])
                            courseGroupServices.save(courseGroup)
                        }
                    }
                }
                line = fileReader.readLine()
            }
        } catch (e: Exception) {

        }

    }

    fun readInstitution() {

        try {
            var line: String?

            val fileReader = BufferedReader(FileReader("edx.csv"))

            // Read CSV header
            fileReader.readLine()

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            var tokens = line.split(",")
            while (line != null && !tokens.contains("lecturerName")) {
                tokens = line.split(",")
                if (tokens.size > 0) {
                    if (line.startsWith("institution")) {
                        while (!tokens.contains("lecturerName")) {
                            line = fileReader.readLine()
                            tokens = line.split(",")
//                        println(tokens[1])
                            val institution = Institution(tokens[0].toInt(), tokens[1])
                            institutionServices.save(institution)
                        }
                    }
                }
                line = fileReader.readLine()
            }
        } catch (e: Exception){

        }


    }

    fun readLecturer() {

        try{
            var line: String?

            val fileReader = BufferedReader(FileReader("edx.csv"))

            // Read CSV header
            fileReader.readLine()

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            var tokens = line.split(",")
            while (line != null && !tokens.contains("topic_id")) {
                tokens = line.split(",")
                if (tokens.size > 0) {
                    if (line.startsWith("lecturerId")) {
                        while (!tokens.contains("topic_id")) {
                            line = fileReader.readLine()
                            tokens = line.split(",")
//                        println(tokens[1])
                            val lecturer = Lecturer(tokens[0].toInt(), tokens[1])
                            lecturerServices.save(lecturer)
                        }
                    }
                }
                line = fileReader.readLine()
            }}
        catch (e: Exception){

        }
    }

    fun readTopic() {

        try{
            var line: String?

            val fileReader = BufferedReader(FileReader("edx.csv"))

            // Read CSV header
            fileReader.readLine()

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            var tokens = line.split(",")
            while (line != null) {
                tokens = line.split(",")
                if (tokens.size > 0) {
                    if (line.startsWith("topic_id")) {
                        while (line != null) {
                            line = fileReader.readLine()
                            tokens = line.split(",")
//                        println(tokens[1])
                            val topic = Topic(tokens[0].toInt(), tokens[1], tokens[2].toInt(), tokens[3].toInt())
                            topicServices.save(topic)
                        }
                    }
                }
                line = fileReader.readLine()
            }}
        catch (e: Exception){

        }


}}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}




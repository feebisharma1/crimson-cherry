-- noinspection SqlNoDataSourceInspectionForFile

-- --------------------------------------------------------
-- Crimson Cherry team
--     Feebi Sharma
--     Sam Beals
--     Sid Bytheway
-- Movie database for team project
-- --------------------------------------------------------

-- Create the fss_movies database
CREATE DATABASE IF NOT EXISTS `fss_movies`;
USE `fss_movies`;

-- Create shell for the movie table
CREATE TABLE IF NOT EXISTS `movie` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4824 DEFAULT CHARSET=latin1;

-- Create shell for the actor table
CREATE TABLE IF NOT EXISTS `actor` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4824 DEFAULT CHARSET=latin1;

-- Create shell for the review table
CREATE TABLE IF NOT EXISTS `review` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4824 DEFAULT CHARSET=latin1;

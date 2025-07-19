/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.TagDAO;
import model.Tag;

import java.util.List;

public class TestTagDAO {
    public static void main(String[] args) {
        TagDAO tagDAO = new TagDAO();

        System.out.println("Fetching all tags from place_tags table...");
        List<Tag> tags = tagDAO.getAllTags();

        if (tags.isEmpty()) {
            System.out.println("No tags found in the database.");
        } else {
            for (Tag tag : tags) {
                System.out.println("Tag ID: " + tag.getTagId() + ", Tag Name: " + tag.getTagName());
            }
        }
    }
}

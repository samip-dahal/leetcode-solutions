/*
Problem Description: https://leetcode.com/problems/product-of-the-last-k-numbers/description/
*/

package org.example;

import java.util.ArrayList;

public class ProductOfLastKNumbers {

    private ArrayList<Integer> prefixProduct = new ArrayList<>();

    private int size = 0;

    public ProductOfLastKNumbers() {

        this.prefixProduct.add(1);

        this.size = 0;
    }

    public void add(int num) {

        if (num == 0) {

            resetProductArray();

        } else {

            this.prefixProduct.add(this.prefixProduct.get(size) * num);

            this.size++;
        }
    }

    public int getProduct(int k) {

        if (k > this.size) {

            return 0;
        }


        return (this.prefixProduct.get(this.size) / this.prefixProduct.get(this.size - k));
    }

    private void resetProductArray() {

        this.prefixProduct = new ArrayList<Integer>();

        this.prefixProduct.add(1);

        this.size = 0;

    }

}

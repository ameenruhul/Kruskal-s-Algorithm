package kruskal;

import  java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Graph {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int nodes;

        System.out.println("How many Nodes?\n");
        nodes = scan.nextInt();


        int [][] matrix = new int [nodes][nodes];
        int [] parent = new int [nodes];

        int min;
        int u =0;
        int v= 0;

        int noOfEdges = 1;
        int total = 0;

        System.out.println("Enter the Matrix :");
        for( int i =0;i<nodes;i++){

            parent[i] =0 ;

            for( int j =0; j<nodes;j++)
            {
                matrix[i][j] = scan.nextInt();
                if(matrix[i][j] == 0)
                {
                    matrix[i][j] = MAX_VALUE ;

                }

            }
        }

        while(noOfEdges < nodes)
        {
            min = MAX_VALUE;

            for (int i = 0; i<nodes; i++)
            {
                for (int j =0; j<nodes;j++)
                {
                    if(matrix[i][j] <min )
                    {
                        min = matrix[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            while (parent[u] != 0)
            {
                u = parent[u];
            }
            while(parent[v] != 0)
            {
                v = parent[v];
            }

            if(v != u)
            {
                noOfEdges = noOfEdges + 1;
                System.out.println("Edge Found : " + u + " --> " +v +" Minimum : " + min);
                total+= min;
                parent[v] = u;

            }

            matrix[u][v] = MAX_VALUE;

        }

        System.out.println("The weight of the minimum spanning tree is : " + total );



    }


}

package org.example;
import org.example.Interf.ProfessorDAO;
import org.example.MODEL.Estudante;
import org.example.MODEL.Professor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Instanciando DAOs
        ProfessorDAO professorDAO = new ProfessorDAO();
        EstudanteDAO estudanteDAO = new EstudanteDAO();

        // Inserindo 3 professores
        List<Professor> professores = Arrays.asList(
                new Professor(0, "Carlos", "Carlos@legal.com", "Matemática"),
                new Professor(0, "Rafaela", "Rafaela@legal.com", "Biologia"),
                new Professor(0, "Kaua", "Kaua@showdebola.com", "Quimica")
        );

        professores.forEach(professorDAO::inserir);

        System.out.println("Lista de Professores:");
        professorDAO.listarTodos().forEach(System.out::println);

        Estudante e1 = new Estudante(0, "João", "João@gmail.com", "467543");
        Estudante e2 = new Estudante(0, "Pedro", "Pedro@gmail.com", "785536");
        Estudante e3 = new Estudante(0, "Alfedro", "Alfedro@gmail.com", "787564");

        estudanteDAO.inserir(e1);
        estudanteDAO.inserir(e2);
        estudanteDAO.inserir(e3);

        System.out.println("\nLista de Estudantes:");
        for (Estudante estudante : estudanteDAO.listarTodos()) {
            System.out.println(estudante);
        }

        System.out.println("\nBuscando Professor com ID 1:");
        System.out.println(Optional.ofNullable(professorDAO.buscarPorId(1))
                .map(Professor::toString)
                .orElse("Professor não encontrado"));

        System.out.println("\nBuscando Estudante com ID 4:");
        Estudante estudanteBuscado = estudanteDAO.buscarPorId(4);
        if (estudanteBuscado != null) {
            System.out.println(estudanteBuscado);
        }

        System.out.println("\nAtualizando professor com ID 2:");
        professorDAO.atualizar(new Professor(2, "Ricardo", "Ricardo@top.com", "Pokemon"));

        System.out.println("\nAtualizando estudante com ID 5:");
        Estudante e4 = new Estudante(5, "Marco", "Marco@gmail.com", "435678");
        estudanteDAO.atualizar(e4);

        System.out.println("\nDeletando um professor com ID 3:");
        professorDAO.deletar(3);
        System.out.println("Professor com ID " + 3 + " deletado.");

        System.out.println("\nDeletando estudante com ID 6:");
        estudanteDAO.deletar(6);
        System.out.println("Estudante com ID " + 6 + " deletado.");
    }
}

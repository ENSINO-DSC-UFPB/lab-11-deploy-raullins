package br.ufpb.dcx.dsc.todolist.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "deadline")
    private LocalDate deadline;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "board_id")
    private Board board;

    public Task(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    // Para o ID não temos set já que ele é gerado automaticamente
    public Long getId() {
        return taskId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", nome='" + nome + '\'' +
                ", deadline=" + deadline +
                ", board=" + board +
                '}';
    }
}

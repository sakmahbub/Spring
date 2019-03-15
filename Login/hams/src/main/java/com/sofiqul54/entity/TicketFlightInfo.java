package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_flight")
public class TicketFlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String ticketNo;
    private String tikAgnName;
    @Column(nullable = false, unique = true)
    private String flightNo;
    @Temporal(TemporalType.DATE)
    private Date flightDate;
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "pilg_id")
    private Pilgrim pilgrim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTikAgnName() {
        return tikAgnName;
    }

    public void setTikAgnName(String tikAgnName) {
        this.tikAgnName = tikAgnName;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Pilgrim getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(Pilgrim pilgrim) {
        this.pilgrim = pilgrim;
    }
}

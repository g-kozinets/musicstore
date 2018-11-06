package by.glko2012.mcstore.dao;

import by.glko2012.mcstore.model.Instruments;

import java.util.List;

public interface InstrumentsDAO {

    void addInstrument(Instruments instruments);

    void removeInstrument(int instrumentId);

    void updateInstrument(Instruments instruments);

    List<Instruments> getInstruments();

    Instruments getInstrumentById(int instrumentId);
}

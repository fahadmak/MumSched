package edu.mum.service;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.mum.domain.Entry;
import edu.mum.domain.Section;
import edu.mum.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	private EntryRepository entryRepository;

	public void saveEntry(Entry entry) {
	
		entryRepository.save(entry);
	}
	public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}

	public Entry getEntry(Long id) {
		return entryRepository.findOne(id);
	}

	public List<Entry> getAllEntry() {
		return (List<Entry>) entryRepository.findAll();
	}

	public Entry getEntryByMonth(String entryMonth) {
		return entryRepository.findByEntryMonth(entryMonth);
	}

	public void deleteEntry(Long id) {
		entryRepository.delete(id);

	}

	public void updateEntry(String entryMonth, int numOfFpp, int numOfMpp, int numOfUSstudents, Long id) {
		entryRepository.update(entryMonth, numOfFpp, numOfMpp, numOfUSstudents, id);
	}
	
	public List<Section> getAllSectionsByEntryId(long id){
		Entry entry = entryRepository.findOne(id);
		List<Section> sections = new ArrayList<>();
		entry.getBlocks().forEach(b-> sections.addAll(b.getSections()));
		return sections;
	}
}

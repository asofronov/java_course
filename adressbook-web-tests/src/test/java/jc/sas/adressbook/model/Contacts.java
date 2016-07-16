package jc.sas.adressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aleks on 16.07.2016.
 */
public class Contacts extends ForwardingSet<NamesData>{

    private Set<NamesData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<NamesData>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<NamesData>();
    }

    public Contacts withAdded(NamesData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(NamesData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    @Override
    protected Set<NamesData> delegate() {
        return delegate;
    }
}

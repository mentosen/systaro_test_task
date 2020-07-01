<template>
    <div v-if="groupNotes.length > 0" class="noteContainer">
        <div class="noteContainer" v-for="group in groupNotes" :key="group.date">
            <span class="noteContainer__date">{{group.date}}</span>
            <div class="noteContainer noteContainer_row">
                <note-component v-for="note in group.notes" :key="note.id" :note="note" @get-notes="getAll"/>
            </div>
        </div>
        <button class="btn btn__add-note" @click="isAddNote = true">+</button>

        <modal v-if="isAddNote" @close="isAddNote = false">
            <div slot="header" class="tile__row">
                <span>Write your note</span>
            </div>

            <div slot="body">
                <textarea
                        cols="100"
                        rows="10"
                />
            </div>

            <div slot="footer" class="tile__row tile__row--flex-end tile__row--padding-top">
                <button>Save</button>
                <button>Close</button>
            </div>
        </modal>
    </div>
</template>

<script>
    import {getAll} from "@/api/noteApi";
    import NoteComponent from "@/components/note/NoteComponent";
    import moment from 'moment';
    import Modal from "@/components/common/ModalWindow";

    export default {
        name: "NoteContainerComponent",
        components:{
            Modal,
            NoteComponent
        },
        data(){
            return {
                groupNotes: [],
                isAddNote: false
            }
        },
        mounted() {
            this.getAll();
        },
        methods:{
            getAll(){
                let that = this;
                getAll().then(response => {
                    that.groupNotesByDate(response.data)
                })
            },
            groupNotesByDate(notes){
                let that = this;
                let groups = notes.reduce((groups, note) => {
                    let date = moment(note.create_date).format('YYYY-MM-DD');

                    if (!groups[date]) {
                        groups[date] = [];
                    }

                    groups[date].push(note);
                    return groups;
                }, {});

                that.groupNotes = Object.keys(groups).map((date) => {
                    return {
                        date,
                        notes: groups[date]
                    };
                });
            }
        }
    }
</script>

<style scoped>

</style>
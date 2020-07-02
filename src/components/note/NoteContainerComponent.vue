<template>
    <div>
        <div v-if="groupNotes.length === 0" class="note_placeholder">
            <span class="note_placeholder__message">Create your first note</span>
        </div>
        <div v-else class="noteContainer">
            <div class="noteContainer" v-for="group in groupNotes" :key="group.date">
                <span class="noteContainer__date">{{group.date}}</span>
                <div class="noteContainer noteContainer_row">
                    <note-component v-for="note in group.notes" :key="note.id" :note="note" @get-notes="getAll" @update="showUpdateModal"/>
                </div>
            </div>
        </div>

        <modal v-if="isShowNoteModal">
            <div slot="header" class="note_create-header">
                <span class="note_create-header__title">Write your note</span>
            </div>

            <div slot="body">
                <textarea
                        class="note_create-body"
                        v-model="message"
                        rows="10"
                />
            </div>

            <div slot="footer" class="note_create-footer">
                <button v-if="isCreateNote"
                        class="btn btn__create-block btn__create-block_green btn__create-block_margin-right"
                        @click="create">
                    Save
                </button>
                <button v-else
                        class="btn btn__create-block btn__create-block_yellow btn__create-block_margin-right"
                        @click="update">
                    Update
                </button>
                <button class="btn btn__create-block btn__create-block_red" @click="close">Close</button>
            </div>
        </modal>
        <button class="btn btn__add-note" @click="isShowNoteModal = true">+</button>
    </div>
</template>

<script>
    import {getAll, create, update} from "@/api/noteApi";
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
                isShowNoteModal: false,
                isCreateNote: true,
                message: "",
                currentNote: {}
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
            },
            create(){
                let that = this;
                let params = {
                    message: that.message.trim()
                };

                create(params).then(response => {
                  that.getAll();
                  that.close();
                })
            },
            showUpdateModal(note){
                let that = this;
                debugger
                that.isCreateNote = false;
                that.isShowNoteModal = true;
                that.message = note.message;

                that.currentNote = note;
            },
            update(){
                let that = this;
                that.currentNote.message = that.message;

                update(that.currentNote).then(response => {
                    that.getAll();
                    that.close();
                })
            },
            close(){
                let that = this;
                that.isShowNoteModal = false;
                that.isCreateNote = true;
                that.message = "";
            }
        }
    }
</script>

<style scoped>

</style>